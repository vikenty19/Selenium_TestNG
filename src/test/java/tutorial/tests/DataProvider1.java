package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.DataProviderExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider1 extends BaseTest {



    @Test(dataProvider = "setOfData",dataProviderClass = DataProviderExamples.class)
    public void loginDDTest(String email1,String password1){
        driver.get(URL);
        BasePage basePage =new BasePage(driver);
        //login
       basePage.findElement(By.cssSelector(".fa-user")).click();
       basePage.findElement(By.xpath("//li/a[text()='Login']")).click();
        WebElement emailBtn = basePage.waitUntilClickable(By.id("input-email"));
        emailBtn.click();
        emailBtn.sendKeys(email1);
        WebElement login =
                basePage.waitUntilClickable(By.id("input-password"));
        login.sendKeys(password1);
        basePage.findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(basePage.waitUntilVisible(By.xpath("//h2[text() = 'My Account']")).isDisplayed());
        tearDown();

    }
    // In case if  there ara many field to insert
    @Test(dataProvider = "setOfData",dataProviderClass = DataProviderExamples.class)
    public void loginDDTest1(String[] str){
        BasePage basePage = new BasePage(driver);
        driver.get(URL);
        //login
       driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.xpath("//li/a[text()='Login']")).click();
        WebElement emailBtn = basePage.waitUntilClickable(By.id("input-email"));
        emailBtn.click();
        emailBtn.sendKeys(str[0]);
        WebElement login =
               basePage.waitUntilClickable(By.id("input-password"));
        login.sendKeys(str[1]);
        driver.findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(basePage.waitUntilVisible(By.xpath("//h2[text() = 'My Account']")).isDisplayed());
        tearDown();

    }

}
