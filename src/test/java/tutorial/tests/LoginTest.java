package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginSuccess() {
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        Assert.assertTrue((loginPage.accountCreated().isDisplayed()));


    }
    @Test
    public  void test(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage =new LoginPage(driver);
        System.out.println(loginPage.generateLogin());
          System.out.println(basePage.generateLogin());
    }


    @Test(priority = 2)//,invocationCount = 3
  public void loginNegative(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(URL);
        loginPage.enterLogin();
        WebElement email = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#input-email")));
        email.clear();
        String invalidLogin = basePage.generateLogin();
        email.sendKeys(invalidLogin + "@gmail.com");
        System.out.println(invalidLogin + "@gmail.com");
      driver.findElement(By.cssSelector("#input-password")).sendKeys("12345");
      driver.findElement(By.xpath("//input[@type ='submit']")).click();
      WebElement alert = wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.cssSelector(".alert")));
      Assert.assertTrue((alert.isDisplayed()));
  //   tearDown();

  }



}
