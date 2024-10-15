package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecCalendar extends BasePage {
    @Test
            public void javaScriptInsertData() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("document.getElementById('datepicker').value = '03/05/1968'");

    }
}
