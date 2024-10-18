package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableHandle extends BasePage {

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
}
