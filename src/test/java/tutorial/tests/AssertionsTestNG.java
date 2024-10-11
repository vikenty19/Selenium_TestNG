package tutorial.tests;

import com.tutorial.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.CacheRequest;
import java.time.Duration;

public class AssertionsTestNG extends BasePage {
    String expectedTitle = "Your Store";

    @Test
    public void assertEqual(){
        manager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Getting title
        String getTitle = driver.getTitle();
        //Aseertion
        Assert.assertEquals(getTitle,expectedTitle);

    }






}
