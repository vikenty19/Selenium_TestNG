package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiWindowHandlePage extends BasePage{

    public MultiWindowHandlePage(WebDriver givenDriver) {
        super(givenDriver);


    }
    By textLocator = By.cssSelector("#ta1");
    public void enterTextInParentWindow(String text){
        WebElement textFiled = waitUntilClickable(textLocator);
        textFiled.sendKeys(text);
    }


}
