package tutorial.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class IframeHandle extends BaseTest{
    @Test
    public void iframeByIdOrName() throws InterruptedException {
        driver.get(frame);
        driver.switchTo().frame("classFrame");//id or locator or name or index

   driver.findElement(By.linkText("Description")).click();
;
    }
    @Test
    public void iframeNested() throws InterruptedException {
        driver.get("https://letcode.in/frame");
        driver.switchTo().frame("firstFr");
        driver.findElement(By.name("fname")).sendKeys("Admin");
        driver.findElement(By.name("lname")).sendKeys("Google");
        Thread.sleep(4000);
        WebElement childFrame = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("iframe[src= 'innerframe']")));
        driver.switchTo().frame(childFrame);

    }
}
