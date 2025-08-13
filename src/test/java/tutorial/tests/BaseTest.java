package tutorial.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver = null ;
    protected WebDriverWait wait = null;
    protected WebDriverManager manager = null;
    protected Actions action= null;
    String URL = "http://tutorialsninja.com/demo/";
    String url ="https://omayo.blogspot.com/";
    public static String koelUrl = "https://qa.koel.app/";
    protected String email = "vv@mail.ru";
    protected String password = "megadelta";
    protected String passwordTutorial = "12345";
    @BeforeMethod
    public void setUpBrowser(){
        manager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
