package com.tutorial;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.Date;

public class BasePage {
    protected  WebDriver driver ;
    protected WebDriverWait wait;
    protected WebDriverManager manager;
    protected Actions action;

    public BasePage(WebDriver givenDriver){
        this.driver = givenDriver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    //    manager.chromedriver().setup();
        action = new Actions(givenDriver);
        PageFactory.initElements(driver,this);


    }

public String generateLogin() {
  Faker faker = new Faker();
  String loginNegative = faker.animal().name();
  return loginNegative;
}

public String generateEmailTimeStamp(){
    Date data =new Date();
    String randomGmail = data.toString().replace(" ","_").replace(":","_")+"@gmail.com";
    return randomGmail.substring(8);
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


  public WebElement findElement(By locator){
  return wait.until(ExpectedConditions.elementToBeClickable(locator));

  }
 @AfterMethod(enabled = true)
  public void tearDown(){
  driver.quit();
 }


  @BeforeMethod
  public void setUpBrowser(){
    manager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

}
