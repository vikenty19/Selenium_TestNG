package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By regLocator = By.linkText("Register");
    By fname = By.cssSelector("#input-firstname");
    By lname = By.cssSelector("#input-lastname");
    By emailLocator = By.cssSelector("#input-email");
    By phoneLocator = By.cssSelector("#input-telephone");
    By passLocator = By.cssSelector("#input-password");
    By passConfirm = By.cssSelector("#input-confirm");
    By policyLocator = By.cssSelector("[name = 'agree']");
    By submitLocator = By.cssSelector("input[type = 'submit']");
    By successLocator = By.xpath("//h1[text() ='Your Account Has Been Created!']");

    public void openAccountRegisterPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(loginPage.accountEnterBtn).click();
        driver.findElement(regLocator).click();

    }

    public void enterCredentials(Object[] credentials) {
        BasePage basePage = new BasePage(driver);
        WebElement fName = basePage.waitUntilVisible(fname);
        fName.sendKeys((String) credentials[0]);
        WebElement lName = basePage.waitUntilVisible(lname);
        lName.sendKeys((String) credentials[1]);
        WebElement email = basePage.waitUntilVisible(emailLocator);
        email.sendKeys((String) credentials[2]);
        WebElement phone = basePage.waitUntilVisible(phoneLocator);
        phone.sendKeys((String) credentials[3]);

    }

    public void createPasswordAndConfirm(Object[] credentials) {
        BasePage basePage = new BasePage(driver);
        WebElement pass = basePage.waitUntilVisible(passLocator);
        pass.sendKeys((String) credentials[4]);
        WebElement passConfirmation = basePage.waitUntilVisible(passConfirm);
        passConfirmation.sendKeys((String) credentials[4]);
    }

    public void agreeWithPolicy() {
        BasePage basePage = new BasePage(driver);
        WebElement policy = basePage.waitUntilVisible(policyLocator);
        policy.click();
    }

    public void clickSubmitBtn() {
        BasePage basePage = new BasePage(driver);
        basePage.waitUntilVisible(submitLocator).click();
    }

    public WebElement accountCreated() {
        BasePage basePage = new BasePage(driver);
        WebElement success = basePage.waitUntilVisible(successLocator);
        return success;
    }
}
