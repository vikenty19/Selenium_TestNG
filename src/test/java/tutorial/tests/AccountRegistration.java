package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.DataProviderExamples;
import com.tutorial.LoginPage;
import com.tutorial.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountRegistration extends BaseTest {
    @Test(dataProvider = "Register new customer", dataProviderClass = DataProviderExamples.class)
    public void negativeWithSomeEmptyFields(Object[] data) {
        driver.get(URL);
        BasePage basePage = new BasePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openAccountRegisterPage();
        registerPage.enterCredentials(data);
        registerPage.createPasswordAndConfirm(data);
        registerPage.agreeWithPolicy();
        registerPage.clickSubmitBtn();
        WebElement success = basePage.waitUntilVisible(By.xpath("//h1[text() ='Your Account Has Been Created!']"));
        Assert.assertTrue(success.isDisplayed());
    }
}
