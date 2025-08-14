package tutorial.tests;
import com.tutorial.BasePage;
import com.tutorial.DataProviderExamples;
import com.tutorial.LoginPage;
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
        loginPage.clickSubmitBtn();
        Assert.assertTrue((loginPage.accountCreated().isDisplayed()));
    }
    @Test(enabled = false)
    public  void test(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage =new LoginPage(driver);
        System.out.println(loginPage.generateLogin());
          System.out.println(basePage.generateLogin());
    }


    @Test(priority = 2)//,invocationCount = 3
  public void loginInvalidEmail(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String invalidEmail = basePage.generateEmailTimeStamp();
        System.out.println(invalidEmail);
        driver.get(URL);
        loginPage.openLoginPage();
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(passwordTutorial);
        loginPage.clickSubmitBtn();
       // Assert.assertTrue((loginPage.warningAlert().isDisplayed()));
        Assert.assertTrue((loginPage.alertWarning.isDisplayed()));//@FindBy
  }
  @Test(dataProvider = "LoginValidEmailSupplier",dataProviderClass = DataProviderExamples.class)
public void checkLoginWithDataProvider(String email,String password){

    LoginPage loginPage = new LoginPage(driver);
    driver.get(URL);
    loginPage.openLoginPage();
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickSubmitBtn();
     Assert.assertTrue((loginPage.warningAlert().isDisplayed()));
   // Assert.assertTrue((loginPage.alertWarning.isDisplayed()));//@FindBy

}           //another way using array as an argument
    @Test(dataProvider = "credentialsArraySupplier",dataProviderClass = DataProviderExamples.class)
    public void checkLoginWithDataProviderArray(String[]str){

        LoginPage loginPage = new LoginPage(driver);
        driver.get(URL);
        loginPage.openLoginPage();
        loginPage.enterEmail(str[0]);
        loginPage.enterPassword(str[1]);
        loginPage.clickSubmitBtn();
        Assert.assertTrue((loginPage.warningAlert().isDisplayed()));
        // Assert.assertTrue((loginPage.alertWarning.isDisplayed()));//@FindBy

    }
}
