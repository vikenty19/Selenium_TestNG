package tutorial.tests;

import com.tutorial.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecCalendar extends BaseTest {


    @Test
    public void javaScriptInsertData() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        WebElement field = driver.findElement(By.id("datepicker"));
        jse.executeScript("arguments[0].value ='05/03/1968'",field);
     //   jse.executeScript("document.getElementById('datepicker').value = '03/05/1968'");
        Thread.sleep(3000);

    }

    @Test
    public void javaScriptEnterText() throws InterruptedException {
        driver.get(url);
        ((JavascriptExecutor) driver).executeScript("document.getElementById('ta1').value = 'Only Chat GPT Knows'");
        Thread.sleep((2000));
    }
}
