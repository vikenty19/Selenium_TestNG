package tutorial.tests;

import com.beust.ah.A;
import com.tutorial.BasePage;
import org.apache.commons.io.input.TaggedReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v138.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Action extends BaseTest {


    @Test
    public void moveToElement() {
   /*     manager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/
        BasePage basePage = new BasePage(driver);
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement blog = basePage.waitUntilClickable(By.cssSelector("#blogsmenu"));
        actions.moveToElement(blog).perform();
        WebElement secondOption = basePage.waitUntilClickable(By.xpath("//span[contains(text(), 'SeleniumOneByArun')]"));
        actions.moveToElement(secondOption).click().build().perform();

        //secondOption.click(); // yuo can do in it way

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
      /*  manager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        BasePage basePage = new BasePage(driver);
        driver.get(url + "p/page3.html");
        WebElement slider =basePage.waitUntilClickable(By.xpath("//a[@aria-labelledby='price-min-label']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -100, 0).perform();
        Thread.sleep(2000);


    }

    @Test
    public void dragAndMoveTo() throws InterruptedException {
        manager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions = new Actions(driver);
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement norway = driver.findElement(By.id("box101"));
        actions.clickAndHold(stockholm).moveToElement(norway).release().build().perform();
        // actions.dragAndDrop(stockholm,norway); the same but work worse
        Thread.sleep(2000);

    }

    @Test
    public void pressKeyDownAndUp() throws InterruptedException {
        manager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement compediumLink = driver.findElement(By.linkText("compendiumdev"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).moveToElement(compediumLink)
                .click().keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(4000);


    }


    }
