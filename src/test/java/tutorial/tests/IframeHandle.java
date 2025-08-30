package tutorial.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

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
        driver.findElement(By.name("email")).sendKeys("a@yu.io");
        Thread.sleep(4000);

    }
    @Test
    public void iframeIterator(){
        driver.get("https://docs.oracle.com/javase/8/docs/api");
        List<WebElement> iframeList = driver.findElements(By.tagName("frame"));//By.xpath("//frame"));
        int framesNumber = iframeList.size();
        int index=0;
             for(int i=0;i<framesNumber;i++){
            driver.switchTo().frame(i);

            if(driver.findElements(By.linkText("Description")).size()>0){
               index = i;
                driver.switchTo().parentFrame();
                break;

            }
            driver.switchTo().parentFrame();
        }
        driver.switchTo().frame(index);
        driver.findElement(By.linkText("Description")).click();


    }
}
