package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.MultiWindowHandlePage;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class MultiWindowHandling extends BaseTest {
    Set<String> allwindows;

    @Test
    public void getWindowsHandle() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        MultiWindowHandlePage handlePage = new MultiWindowHandlePage(driver);
        driver.get(url);
         String defaultTitle = driver.getTitle();
        handlePage.enterTextInParentWindow("Sergey Dovlatov");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Open a popup window")).click();
        driver.findElement(By.linkText("Blogger")).click();
         allwindows = driver.getWindowHandles();
        switchToWindow("New Window");
        String popUpWindow = driver.findElement(By.cssSelector(".example>h3")).getText();
        System.out.println(popUpWindow);

         switchToWindow("Blogger.com - Create a unique and beautiful blog easily.");

      WebElement text2 = basePage.waitUntilVisible(By.cssSelector(".logo-type"));
        System.out.println(text2.isDisplayed());
         WebElement signIn = basePage.waitUntilClickable(By.cssSelector(".sign-in"));
         signIn.click();
        Assert.assertTrue(basePage.waitUntilVisible(By.cssSelector("h1>span")).isDisplayed());
        driver.switchTo().window(parentWindow);
        Assert.assertEquals(driver.getTitle(),defaultTitle);
        System.out.println(driver.getTitle());
        }





    public void switchToWindow(String title) {
        Iterator<String> itr = allwindows.iterator();
        while (itr.hasNext()) {
            String win = itr.next();
            driver.switchTo().window(win);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }

    }
}