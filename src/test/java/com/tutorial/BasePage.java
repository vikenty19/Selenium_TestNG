package com.tutorial;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BasePage {
  protected  WebDriver driver ;
  protected WebDriverWait wait;
  protected static WebDriverManager manager;
  protected String url ="https://omayo.blogspot.com/";
  protected String URL = "http://tutorialsninja.com/demo/";
  protected String koelUrl = "https://qa.koel.app/";
  By passwordBtn = By.cssSelector("#input-password");
  By emailBtn =By.cssSelector("#input-email");
    protected String email = "vv@mail.ru";
    protected String password = "megadelta";
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
 @AfterMethod(enabled = false)
  public void tearDown(){
  driver.quit();
 }

  @BeforeSuite
 public void setUpDriver(){
    WebDriverManager.chromedriver().setup();

  }
  @BeforeMethod
  public void setUpBrowser(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

}
