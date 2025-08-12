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

/*   By accountBtn = By.xpath("//h2[text()='My Account']");

   By loginBtn = By.linkText("Login");

   By accountEnterBtn= By.cssSelector(".fa-user");
   By submitBtn = By.xpath("//input[@type ='submit']");*/


    @Test(priority = 1)
    public void loginSuccess() {


        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        driver.findElement(loginPage.accountEnterBtn).click();
        WebElement login =basePage.waitUntilClickable(loginPage.loginBtn);
        login.click();
        basePage.enterEmail(email);
        basePage.enterPassword(password);
        driver.findElement(loginPage.submitBtn).click();
        WebElement account = basePage.waitUntilVisible(loginPage.accountBtn);
        Assert.assertTrue((account.isDisplayed()));
        tearDown();

    }
    @Test
    public  void test(){
        BasePage basePage = new BasePage(driver);

        System.out.println(basePage.generateEmailTimeStamp());
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
