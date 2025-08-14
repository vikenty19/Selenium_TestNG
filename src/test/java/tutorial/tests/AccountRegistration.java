package tutorial.tests;

import com.beust.ah.A;
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
    public void loginSuccess(Object[] data) {
        driver.get(URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openAccountRegisterPage();
        registerPage.enterCredentials(data);
        registerPage.createPasswordAndConfirm(data);
        registerPage.agreeWithPolicy();
        registerPage.clickSubmitBtn();
        Assert.assertTrue(registerPage.accountCreated().isDisplayed());
            }
    @Test(dataProvider ="credentialsWithEmptyField",dataProviderClass = DataProviderExamples.class)
    public void negativeWithSomeEmptyFields(Object[]data){
        driver.get(URL);
        BasePage basePage = new BasePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openAccountRegisterPage();
        registerPage.enterCredentials(data);
        registerPage.createPasswordAndConfirm(data);
        registerPage.agreeWithPolicy();
        registerPage.clickSubmitBtn();
        WebElement alert = basePage.waitUntilVisible(By.cssSelector(".alert"));
        Assert.assertTrue(alert.getText().contains("Warning"));
    }
}
