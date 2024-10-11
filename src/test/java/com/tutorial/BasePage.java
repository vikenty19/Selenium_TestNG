package com.tutorial;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BasePage {
  protected  WebDriver driver;
  protected WebDriverWait wait;
  protected static WebDriverManager manager;
  protected String url ="https://omayo.blogspot.com/";
  protected String URL = "http://tutorialsninja.com/demo/";
  protected String koelUrl = "https://qa.koel.app/";
  By passwordBtn = By.cssSelector("#input-password");
  By emailBtn =By.cssSelector("#input-email");
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
  public void enterPassword(String passWord) {
    driver.findElement(passwordBtn).sendKeys(passWord);
  }

  public void enterEmail(String email) {
    WebElement emailLocator=waitUntilClickable(emailBtn);
    emailLocator.clear();
    emailLocator.sendKeys(email);

  }

  public WebElement findElement(By locator){
  return wait.until(ExpectedConditions.elementToBeClickable(locator));

  }
 @AfterMethod(enabled = true)
  public void tearDown(){
  driver.quit();
 }
}
