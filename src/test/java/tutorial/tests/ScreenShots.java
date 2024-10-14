package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShots extends BasePage {
     @Test
             public void getScrenShot() throws IOException {
         manager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         driver.get(url);
         File srcFile = ((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE) );//create a file with screenShot
         FileHandler.copy(srcFile,new File("./screenshots/homePage.png"));//directory screenshots must be created in advance
     }

}
