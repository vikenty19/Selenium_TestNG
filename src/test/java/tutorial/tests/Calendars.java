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
       //created method
     //   selectDate("2023","March","32");
        selectDate("2023","October","30");
      //  selectDate("2024","January","1");
     //   selectDate("2024","July","341");
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
    }
    //create universal method
    public void selectDate(String yearPick,String monthPick,String datePick){

        String monthYear = waitUntilVisible(By.className("ui-datepicker-title")).getText();
        String month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
        String year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        String[] oddMonth = {"January","March","May","July","August","October","December"};
        String[] evenMonth = {"April","June","September","November"};
        while(!(month.equals(monthPick)&& year.equals(yearPick))){
            for(String i :oddMonth){
                if(Integer.parseInt(datePick)>31){
                    System.out.println("You enter a day not existing ");
                    return;
            }
            }
            for (String i:evenMonth){
                if(Integer.parseInt(datePick)>30){
                    System.out.println("You enter a day not existing ");
                    return;
                }
            }
            if(monthPick.equals("February")&& Integer.parseInt(datePick)>29){
                System.out.println("Invalid day is provided  "+ datePick+"/"+monthPick+"/"+yearPick);
                return;
            }

            WebElement previous = waitUntilVisible(By.cssSelector(".ui-icon-circle-triangle-w"));
            previous.click();
            month = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            year = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        }
        // while is ended
        String xpathText = "//a[text()=\'"+datePick+"\']";//a[text() ='30']

        try {
            findElement(By.xpath(xpathText)).click();
        }catch (Exception e){
            System.out.println("Invalid data provided  "+ datePick+"/"+monthPick+"/"+yearPick);
        }

    }

    }
