package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.DataProviderExamples;
import com.tutorial.LoginPage;
import com.tutorial.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountRegistration extends BaseTest{
  @Test(dataProvider = "Register new customer",dataProviderClass = DataProviderExamples.class)
    public void negativeWithSomeEmptyFields(Object[]data){
      driver.get(URL);
        BasePage basePage = new BasePage(driver);
         RegisterPage registerPage = new RegisterPage(driver);
         registerPage.openAccountRegisterPage();
          registerPage.enterCredentials(data);
        WebElement pass = basePage.waitUntilVisible(By.cssSelector("#input-password"));
        pass.sendKeys(password);
      WebElement passConfirm = basePage.waitUntilVisible(By.cssSelector("#input-confirm"));
      passConfirm.sendKeys(password);
        WebElement policy = basePage.waitUntilVisible(By.cssSelector("[name = 'agree']"));
        policy.click();
         basePage.waitUntilVisible(By.cssSelector("input[type = 'submit']")).click();
         WebElement success = basePage.waitUntilVisible(By.xpath("//h1[text() ='Your Account Has Been Created!']"));
    Assert.assertTrue(success.isDisplayed());
    }
}
