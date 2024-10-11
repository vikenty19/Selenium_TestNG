package tutorial.tests;

import com.tutorial.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.CacheRequest;

public class AssertionsTestNG extends BasePage {
    String expectedTitle = "Your Store";
    @Test
    public void assertEqual(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        //Getting title
        String getTitle = driver.getTitle();
        //Aseertion
        Assert.assertEquals(getTitle,expectedTitle);




    }
}
