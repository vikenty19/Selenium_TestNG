package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableHandlePaginator extends BaseTest {



    @Test
    public void printTableWithTitle() {

        driver.get(url);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'table1']//tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id = 'table1']//th"));
        for (int i = 1; i <= rows.size(); i++) {
            //i=1 table title is printed
            if (i == 1) {
                for (int j = 1; j <= columns.size(); j++) {
                    String xpath = "//table[@id = 'table1']//th[" + j + "]";
                    System.out.print(driver.findElement(By.xpath(xpath)).getText() + " ");
                }//Body of table
            } else {
                for (int j = 1; j <= columns.size(); j++) {
                    //i-1 to reach 1st row of table
                    String xpath = "//table[@id = 'table1']//tr[" + (i - 1) + "]//td[" + j + "]";
                    System.out.print(driver.findElement(By.xpath(xpath)).getText() + " ");

                }
            }
            System.out.println();
        }
        tearDown();
    }

    @Test
    public void handleDynamicTable() throws InterruptedException {
        driver.get("https://demo3x.opencartreports.com/admin/");
        BasePage basePage = new BasePage(driver);

      basePage.findElement(By.id("input-password")).sendKeys("demo");
        basePage.findElement(By.cssSelector("[type = 'submit']")).click();
        basePage.findElement(By.cssSelector("#menu-sale>a")).click();
        basePage.findElement(By.xpath("//a[text() = 'Orders']")).click();
        String customerName = "Billy Brooks";

        // for pagination we need number of pages
        String pagesText = basePage.findElement(By.cssSelector(".col-sm-6.text-right")).getText();
        System.out.println(pagesText);
        int inception = pagesText.indexOf("(");
        int completion = pagesText.indexOf("Pages");
        String numberOfPages = pagesText.substring(inception + 1, completion - 1);
        int pages = Integer.parseInt(numberOfPages);
        for (int p = 1; p <= pages; p++) {
            String xpathText =
                    "(//form[@id ='form-order']//tr//td/a[contains(text(),'" + customerName + "')])[1]";
            //Use try because name may not appear on this page

            try {
                String name = basePage.findElement(By.xpath(xpathText)).getText();
                System.out.println(name);
                if (basePage.findElement(By.xpath(xpathText)).isDisplayed()) {
                    //adding xpath end point to get to the check-box
                    String finalXpath = xpathText + "/..//preceding-sibling::td[2]";
                    basePage.findElement(By.xpath(finalXpath)).click();
                    break;
                }
            } catch (Throwable t) {

            }
            //Switch to the next page if needed
            basePage.findElement(By.xpath
                    ("//ul[@class='pagination']/li[@class='active']/span/following::a[2]")).click();
        }

        tearDown();

    }
}
