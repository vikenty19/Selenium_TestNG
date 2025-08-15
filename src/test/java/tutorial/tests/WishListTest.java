package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{


    @Test
    public void addProductToWishListAndViewList(){
        driver.get(URL);
        //login
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginUser(email,password);
        //find product
       WebElement searchField = basePage.waitUntilClickable(By.cssSelector("[name = search]"));
       searchField.click();
       searchField.clear();
       searchField.sendKeys("HP", Keys.ENTER);

       // Move product to the wishList
        driver.findElement(By.cssSelector("button>.fa-heart")).click();
        Assert.assertTrue(basePage.waitUntilVisible(By.cssSelector(".alert-success")).isDisplayed());
        //view wish list
      //  driver.findElement(By.linkText("wish list")).click();
        WebElement wishLink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("wish list")));
        wishLink.click();
        Assert.assertTrue(basePage.waitUntilVisible(By.xpath("//div[@id='content']/h2")).isDisplayed());
        Assert.assertTrue(driver.getTitle().equals("My Wish List"));


    }
    @Test(dependsOnMethods = {"addProductToWishListAndViewList"})
    public void removeItemFromWishList(){
        BasePage basePage = new BasePage(driver);
        WebElement removeBtn = basePage.waitUntilClickable(By.cssSelector(".fa-times"));
        removeBtn.click();
        WebElement emptyWishList = basePage.waitUntilVisible(By.xpath("//div[@id = 'content']/p"));
        Assert.assertEquals(emptyWishList.getText(), "Your wish list is empty.");
    }
}
