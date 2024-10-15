package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Calendars extends BasePage {
    @Test
    public void calendar1() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement dataField =waitUntilClickable(By.cssSelector("input#datepicker"));
        dataField.click();
        //wait for calendar appearance
        waitUntilVisible(By.id("ui-datepicker-div"));
        //created method
        selectDate("2023", "March", "32");
        selectDate("2023", "December", "31");

      //
        driver.navigate().refresh();
        Thread.sleep(1000);

        selectDate("2023", "January", "1");
     /*
        selectDate("2024", "July", "341");
        driver.navigate().refresh();
        selectDate("2024", "February", "29");*/
        //check the month and the year
   /*     String monthYear = waitUntilVisible(By.className("ui-datepicker-title")).getText();
        System.out.println(monthYear);
        String month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
        String year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
      ;
        //another way to get month and year
        String[]my = monthYear.split(" ");
        String month1 = my[0];
        String year1  = my[1];
        */

        // pick the date previous
    /*    while(!(month.equals("January")&& year.equals("2022"))){
            findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
            month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        }
        System.out.println(month+ "   "+year);
        findElement(By.xpath("//a[contains(text(),'27')]")).click();*/
        tearDown();
    }

    //create universal method
    public void selectDate(String yearPick, String monthPick, String datePick) {

        String monthYear = waitUntilVisible(By.className("ui-datepicker-title")).getText();
        String month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
        String year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        String[] oddMonth = {"January", "March", "May", "July", "August", "October", "December"};
        String[] evenMonth = {"April", "June", "September", "November"};
        while (!(month.equals(monthPick) && year.equals(yearPick))) {
            for (int i = 0; i < oddMonth.length; i++) {
                if (Integer.parseInt(datePick) > 31 && monthPick.equals(oddMonth[i])) {
                    System.out.println("You enter a day not existing ");
                    return;
                }
            }
            for (int i = 0; i < evenMonth.length; i++) {
                if (Integer.parseInt(datePick) > 30 && monthPick.equals(evenMonth[i])) {
                    System.out.println("You enter a day not existing ");
                    return;
                }
            }
            if (monthPick.equals("February") && Integer.parseInt(datePick) > 29) {
                System.out.println("Invalid day is provided  " + datePick + "/" + monthPick + "/" + yearPick);
                return;
            }

            WebElement previous = waitUntilVisible(By.cssSelector(".ui-icon-circle-triangle-w"));
            previous.click();
            month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        }
        // while is ended
        String xpathText = "//a[text()=\'" + datePick + "\']";//a[text() ='30']

        try {
            findElement(By.xpath(xpathText)).click();
        } catch (Exception e) {
            System.out.println("Invalid data provided  " + datePick + "/" + monthPick + "/" + yearPick);
        }

    }

}
