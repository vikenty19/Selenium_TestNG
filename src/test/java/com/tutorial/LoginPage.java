package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;

public class LoginPage extends BasePage {
   public By accountBtn = By.xpath("//h2[text()='My Account']");

    public By loginBtn = By.linkText("Login");

    public By accountEnterBtn= By.cssSelector(".fa-user");
    public By submitBtn = By.xpath("//input[@type ='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }



    public void enterLogin() {
        driver.findElement(By.cssSelector(".fa-user")).click();
        WebElement login = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Login")));
        login.click();
    }
}
