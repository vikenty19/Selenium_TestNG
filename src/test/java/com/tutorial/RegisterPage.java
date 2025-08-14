package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   By regLocator = By.linkText("Register");
   By fname =By.cssSelector("#input-firstname");
   By lname = By.cssSelector("#input-lastname");
   By emailLocator = By.cssSelector("#input-email");
   By phoneLocator =By.cssSelector("#input-telephone");
   By passLocator = By.cssSelector("#input-password");
   By policyLocator = By.cssSelector("[name = 'agree']");
   By submitLocator = By.cssSelector("input[type = 'submit']");

    public void openAccountRegisterPage() {
       LoginPage loginPage = new LoginPage(driver);
        driver.findElement(loginPage.accountEnterBtn).click();
        driver.findElement(regLocator).click();

    }
    public void enterCredentials(Object[]credentials){
        BasePage basePage = new BasePage(driver);
        WebElement fName = basePage.waitUntilVisible(fname);
        fName.sendKeys((String)credentials[0]);
        WebElement lName = basePage.waitUntilVisible(lname);
        lName.sendKeys((String)credentials[1]);
        WebElement email = basePage.waitUntilVisible(emailLocator);
        email.sendKeys((String)credentials[2]);
        WebElement phone = basePage.waitUntilVisible(By.cssSelector("#input-telephone"));
        phone.sendKeys((String)credentials[3]);

    }


}
