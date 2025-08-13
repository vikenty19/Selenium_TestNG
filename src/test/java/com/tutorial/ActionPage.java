package com.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionPage extends BasePage{
    public ActionPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public By silderLocator = By.xpath("//a[@aria-labelledby='price-min-label']");
    public WebElement slider(By locator){
        return  waitUntilClickable(silderLocator);
    }
}
