package tutorial.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    }

}
