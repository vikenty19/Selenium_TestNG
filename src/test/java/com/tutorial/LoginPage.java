package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;

public class LoginPage extends BasePage {
    public By accountBtn = By.xpath("//h2[text()='My Account']");

    public By loginBtn = By.linkText("Login");

    public By accountEnterBtn = By.cssSelector(".fa-user");
    public By submitBtn = By.xpath("//input[@type ='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void openLoginPage() {
        BasePage basePage = new BasePage(driver);
        driver.findElement(accountEnterBtn).click();
        WebElement login = basePage.waitUntilClickable(loginBtn);
        login.click();
    }
    public WebElement accountCreated(){
        BasePage basePage = new BasePage(driver);
        driver.findElement(submitBtn).click();
        WebElement account = basePage.waitUntilVisible(accountBtn);
        return account;
    }
    public void enterPassword(String passWord) {
        driver.findElement(passwordBtn).sendKeys(passWord);
    }

    public void enterEmail(String email) {
        WebElement emailLocator=waitUntilClickable(emailBtn);
        emailLocator.clear();
        emailLocator.sendKeys(email);

    }
    public String generateLogin() {
        String login = "1223";
        return login;

    }


    public void enterLogin() {
        driver.findElement(By.cssSelector(".fa-user")).click();
        WebElement login = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Login")));
        login.click();
    }
}
