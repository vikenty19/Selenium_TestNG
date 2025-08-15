package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest{
    @Test
    public void addProductToWishListAndViewList(){
        driver.get(URL);
        //login
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
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
        driver.findElement(By.linkText("wish list")).click();
        Assert.assertTrue(basePage.waitUntilVisible(By.xpath("//div[@id='content']/h2")).isDisplayed());
        Assert.assertTrue(driver.getTitle().equals("My Wish List"));


    }
}
