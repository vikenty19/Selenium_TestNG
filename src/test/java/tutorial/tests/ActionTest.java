package tutorial.tests;

import com.tutorial.ActionPage;
import com.tutorial.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionTest extends BaseTest {


    @Test
    public void moveToElement() {
        BasePage basePage = new BasePage(driver);
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement blog = basePage.waitUntilClickable(By.cssSelector("#blogsmenu"));
        actions.moveToElement(blog).perform();
        WebElement secondOption = basePage.waitUntilClickable(By.xpath("//span[contains(text(), 'SeleniumOneByArun')]"));
        actions.moveToElement(secondOption).click().build().perform();// build need if 2 commands in one line

        //secondOption.click(); // you can do in it way

    }

    @Test
    public void dragAndDropBySlider() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        ActionPage actionPage = new ActionPage(driver);
        driver.get(url + "p/page3.html");
        //  WebElement slider = actionPage.slider(actionPage.silderLocator);
        WebElement slider = basePage.waitUntilClickable(actionPage.silderLocator);

        action.dragAndDropBy(slider, -100, 0).perform();
        Thread.sleep(2000);
        action.dragAndDropBy(slider, 200, 0).perform();
        Thread.sleep(2000);

    }
    @Test
    public void DragAndDropByResize() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        driver.get("https://jqueryui.com/resizable");
        WebElement frame = basePage.waitUntilVisible(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement dragPoint = basePage.waitUntilClickable(By.cssSelector(".ui-icon-gripsmall-diagonal-se"));
        action.dragAndDropBy(dragPoint,300,50).perform();
        Thread.sleep(2000);

    }
    @Test
    public void jQueryContextMenu() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement clickButton = basePage.waitUntilClickable(By.cssSelector("span.context-menu-one"));
        action.contextClick(clickButton).perform();
        WebElement queryQuitBtn = basePage.waitUntilClickable(By.xpath("//span[text()='Quit']"));
        action.click(queryQuitBtn).perform();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);

    }
    @Test
    public void EnterTextWithKeys(){

        driver.get(URL+"index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("Arun");
        action.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("Motori")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("ato@ku.ru")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("1237895")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("12345")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .build().perform();
    }


    @Test
    public void contextClick() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        driver.get(URL);
        WebElement searchBox = basePage.waitUntilVisible(By.name("search"));
        action.contextClick(searchBox).perform();
        Thread.sleep(2000);


    }

    @Test
    public void dragAndMoveTo() throws InterruptedException {
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
        driver.get(url);
        WebElement compediumLink = driver.findElement(By.linkText("compendiumdev"));
         //   compediumLink.click();
        //to open in new tab need to hold control key
        action.keyDown(Keys.CONTROL).moveToElement(compediumLink)
                .click().keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(4000);


    }


}
