package tutorial.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends BaseTest {

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
     javaClick(button,driver);
     Thread.sleep(2000);

 }
 @Test
    public void javaScriptFlashing() throws InterruptedException {
        driver.get(URL);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement cartButton =driver.findElement(By.cssSelector("#cart>button"));
        //default color
        String defaultColor = cartButton.getCssValue("background-color");
        for (int i=0; i<=20;i++){
         jse.executeScript("document.querySelector('#cart>button').style.background='green';");
         Thread.sleep(50);
            jse.executeScript("document.querySelector('#cart>button').style.background='"+defaultColor+"';");
        }

 }

public void javaClick(WebElement element, WebDriver driver){
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].click()",element);
}
}
