package com.tutorial;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected  WebDriver driver;
  protected WebDriverWait wait;
  protected String URL = "http://tutorialsninja.com/demo/";
public String generateLogin() {
  Faker faker = new Faker();
  String loginNegative = faker.animal().name();
  return loginNegative;
}
  public WebElement waitUntilVisible(By locator){
    WebElement element= wait.until(ExpectedConditions
            .visibilityOfElementLocated(locator));
    return element;

  }
  public WebElement waitUntilClickable(By locator){
    WebElement elementClick= wait.until(ExpectedConditions
            .elementToBeClickable(locator));
    return elementClick;

  }
}
