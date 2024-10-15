package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Calendars extends BasePage {
    @Test
    public void calendar1(){
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
       WebElement dataField = findElement(By.cssSelector("input#datepicker"));
        dataField.click();
        //wait for calendar appearance
       waitUntilVisible(By.id("ui-datepicker-div"));
       //check the month and the year
        String monthYear = waitUntilVisible(By.className("ui-datepicker-title")).getText();
        System.out.println(monthYear);
        String month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
        String year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
      ;
        //another way to get month and year
        String[]my = monthYear.split(" ");
        String month1 = my[0];
        String year1  = my[1];

  // pick the date previous
        while(!(month.equals("January")&& year.equals("2022"))){
            findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
            month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        }
        System.out.println(month+ "   "+year);
        findElement(By.xpath("//a[contains(text(),'27')]")).click();
    }
}
