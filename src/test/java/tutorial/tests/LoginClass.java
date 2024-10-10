package tutorial.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginClass {
    String URL = "http://tutorialsninja.com/demo/";
    @Test
    public void loginSuccess(){


        WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         driver.get(URL);
         driver.findElement(By.cssSelector(".fa-user")).click();
        WebElement login = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Login")));
        login.click();
        WebElement email = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#input-email")));
        email.clear();
        email.sendKeys("vv@mail.ru");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("megadelta");
        driver.findElement(By.xpath("//input[@type ='submit']")).click();
        WebElement account =wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h2[text() ='My Account']")));
        Assert.assertTrue((account.isDisplayed()));
        driver.quit();

    }

}
