package tutorial.tests;

import com.tutorial.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.CacheRequest;
import java.time.Duration;

import static org.testng.Assert.*;

public class AssertionsTestNG extends BasePage {
    String expectedTitle = "Your Store";

    @Test
    public void assertEqualTitle(){
        manager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Getting title
        String getTitle = driver.getTitle();
        System.out.println(getTitle);
        //Aseertion
         assertEquals(getTitle,expectedTitle,"Title is NOT match"); //static Assert.*

    }

    @Test
    public void example(){
        driver =new EdgeDriver();
        String str = " ";
        Assert.assertNotNull(str);
    }
    // Soft Assert

@Test
public void softAssertEx(){

    manager.chromedriver().setup();
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(koelUrl);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String actualTitle = driver.getTitle();
    SoftAssert softAssert = new SoftAssert();
   softAssert.assertEquals(actualTitle,expectedTitle);
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = URL;
    softAssert.assertEquals(actualUrl,expectedUrl);
  /*  driver.findElement(By.cssSelector("[type='search']")).sendKeys("Lament",Keys.ENTER);
    softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Lament')]")).isDisplayed());*/
    softAssert.assertAll();
}



}
