package tutorial.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.io.IOException;

public class JavaScriptExecutor extends BaseTest {
    @Test
    public void javaScriptScrolling() throws InterruptedException {
        driver.get(url);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
         WebElement buttonToScrollTo= driver.findElement(By.cssSelector("form [value='LogIn']"));
         jse.executeScript("arguments[0].scrollIntoView(true)",buttonToScrollTo);
         Thread.sleep(2000);
         // scrolling to the bottom of the page
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);

    }
    @Test
    public void javaScriptGetTitle(){
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        driver.get(koelUrl);
        String title =jse.executeScript("return document.title").toString();
        String URL = jse.executeScript("return document.URL").toString();
        System.out.println(title+"  "+URL);
    }
    @Test
    public void lavaScriptEnterText() throws InterruptedException {

        driver.get(koelUrl);
        WebElement email = driver.findElement(By.cssSelector("form>[type='email']"));
        javaScriptEnterText(driver,email,"Viktoria@rr.dd");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.cssSelector("form>[type='password']"));
        javaScriptEnterText(driver,password,"12345678");
        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        javaClick(submit,driver);
        Thread.sleep(2000);

    }
    @Test
    public void javaScriptDataPickAlertAndRefresh() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        WebElement dataField = driver.findElement(By.id("datepicker"));
        String dateToEnter = "08/26/2025";
        jse.executeScript("arguments[0].value = '"+dateToEnter+"'",dataField);

        //creating alert informing about successfully entered date
        jse.executeScript("alert('Date has been entered successfully')");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();// close alert
        //refresh
        jse.executeScript("history.go(0)");
        Thread.sleep(2000);
    }
    public void javaScriptEnterText(WebDriver driver,WebElement element,String text){
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value = '"+text+"'",element);
    }

    @Test
    public void javaScriptAlert() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        driver.get(url);
        jse.executeScript("alert('DDDDDDDD')");
        Thread.sleep(2000);


    }

    @Test
    public void javaScriptPrompt() throws InterruptedException {
        driver.get(url);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("prompt('Enter your name')");
        Thread.sleep(2000);
    }

    @Test
    public void javaScriptConfirm() throws InterruptedException {
        driver.get(url);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("confirm('Do you want to proceed?')");
        Thread.sleep(2000);
    }

    @Test
    public void javaScriptClick() throws InterruptedException {
        driver.get(url);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        //    jse.executeScript("document.getElementById('alert1').click()");
        //another way using Webelement
        WebElement button = driver.findElement(By.id("alert1"));
        // jse.executeScript("arguments[0].click()",button);//[0] refer to number of arguments in the line
        //reusable method click
        javaClick(button, driver);
        Thread.sleep(2000);

    }

    @Test
    public void javaScriptFlashing() throws InterruptedException {
        driver.get(URL);
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart>button")));
        //default color
 /*       String defaultColor = cartButton.getCssValue("background-color");
        for (int i=0; i<=20;i++){
         jse.executeScript("document.querySelector('#cart>button').style.background='green';");
         Thread.sleep(50);
            jse.executeScript("document.querySelector('#cart>button').style.background='"+defaultColor+"';");
        }*/
        javaScriptFlash(driver, cartButton);

    }
    @Test
    public void javaScriptBorderAndScreenShot() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get(koelUrl);
        WebElement regForm = driver.findElement(By.cssSelector("form[data-testid='login-form']"));
        jse.executeScript("arguments[0].style.border='5px solid red'",regForm);


         File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile,new File("./KoelScreenshots/highlitedBorder.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        jse.executeScript("arguments[0].style.border=''",regForm);

    }

    public void javaClick(WebElement element, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    public void javaScriptFlash(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String defaultColor = element.getCssValue("background-color");
        for (int i = 0; i <= 20; i++) {
            jse.executeScript("arguments[0].style.background='green';", element);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            jse.executeScript("arguments[0].style.background='" + defaultColor + "';", element);
        }
    }
}
