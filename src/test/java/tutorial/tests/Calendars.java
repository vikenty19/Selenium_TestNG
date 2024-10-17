package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Calendars extends BasePage {
    @Test
    public void calendar1() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement dataField =waitUntilClickable(By.cssSelector("input#datepicker"));
        dataField.click();
        //wait for calendar appearance
        waitUntilVisible(By.id("ui-datepicker-div"));
        //using created method
        selectDate("2023", "March", "32");
         selectDate("2023", "December", "32");
        selectDate("2024", "February", "29");//not solving problem with several query
         dataField.click();
         dataField.clear();
        waitUntilVisible(By.id("ui-datepicker-div"));

        selectDate("2023", "July", "31");
        dataField.click();
        dataField.clear();
        selectDate("2023", "January", "1");
        System.out.println("Huray!!");

        ;
        driver.navigate().refresh();

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
    @Test
    public void calendarUpAndDown(){
        String eDate = "16-10-2024";
       DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eld = LocalDate.parse(eDate,dtf);
        int eDay = eld.getDayOfMonth();
        int eMonth = eld.getMonthValue();
        int eYear = eld.getYear();

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement dataField =waitUntilClickable(By.cssSelector("input#datepicker"));
        dataField.click();
        //wait for calendar appearance
        waitUntilVisible(By.id("ui-datepicker-div"));
        String aMonthText = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
        String aYearText = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
        //convert string "month" format into integer
        Integer actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonthText)
                .get(ChronoField.MONTH_OF_YEAR);
        int actYear=Integer.parseInt(aYearText);
        // go previous month and day
        while(eMonth < actMonth||eYear < actYear){
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
            aMonthText = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            aYearText = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
            actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonthText)
                    .get(ChronoField.MONTH_OF_YEAR);
            actYear=Integer.parseInt(aYearText);
        }
        while(eMonth > actMonth||eYear > actYear){
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            aMonthText = waitUntilVisible(By.cssSelector(".ui-datepicker-month")).getText();
            aYearText = waitUntilVisible(By.cssSelector(".ui-datepicker-year")).getText();
            actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(aMonthText)
                    .get(ChronoField.MONTH_OF_YEAR);
            actYear=Integer.parseInt(aYearText);
        }
//     //Picking a day
        String xpath = " //table[@class ='ui-datepicker-calendar']//td[@data-handler ='selectDay']/a[text()=\'"+eDay+"\']";
            findElement(By.xpath(xpath)).click();
            tearDown();
    }

    @Test
    public void calendarWithTime(){
        driver.get("http://demo.guru99.com/test");
        findElement(By.cssSelector("input[name='bdaytime']")).sendKeys("03051968");
        findElement(By.cssSelector("input[name='bdaytime']")).sendKeys(Keys.TAB);
        findElement(By.cssSelector("input[name='bdaytime']")).sendKeys("0930");
        findElement(By.cssSelector("input[type='submit']")).click();


    }

    @Test(dataProvider = "calendar data")
    public void DropDownCalendar(String Day,String Month,String Year){

        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        findElement(By.cssSelector("#third_date_picker")).click();
       selectDataInCalendar(Day,Month,Year);
       tearDown();
    }

    private void selectDataInCalendar(String selDay,String selMonth,String selYear) {
        WebElement month = waitUntilClickable(By.cssSelector("[data-handler='selectMonth']"));
        Select select = new Select(month);
        select.selectByVisibleText(selMonth);
        WebElement year = waitUntilClickable(By.cssSelector("[data-handler='selectYear']"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText(selYear);
        String eDay = selDay;
        String xpath = ("//table[@class= 'ui-datepicker-calendar']//td[@data-handler='selectDay']/a[text() =\'"+eDay+"\']");
        findElement(By.xpath(xpath)).click();
    }
    @DataProvider(name = "calendar data")
    public Object[][] getData(){
        String[][] date = {{"15","Mar","2027"},{"1","May","2025"},{"31","Dec","2027"},{"1","Jan","2028"}};
        return date;
    }
}
