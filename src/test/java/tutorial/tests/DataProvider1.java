package tutorial.tests;

import com.tutorial.BasePage;
import com.tutorial.DataProviderExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider1 extends BasePage {

    @Test(dataProvider = "setOfData",dataProviderClass = DataProviderExamples.class)
    public void loginDDTest(String email1,String password1){
        driver.get(URL);
        //login
       findElement(By.cssSelector(".fa-user")).click();
       findElement(By.xpath("//li/a[text()='Login']")).click();
        WebElement emailBtn = waitUntilClickable(By.id("input-email"));
        emailBtn.click();
        emailBtn.sendKeys(email1);
        WebElement login =
                waitUntilClickable(By.id("input-password"));
        login.sendKeys(password1);
        findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(waitUntilVisible(By.xpath("//h2[text() = 'My Account']")).isDisplayed());
        tearDown();

    }
    // In case if  there ara many field to insert
    @Test(dataProvider = "setOfData",dataProviderClass = DataProviderExamples.class)
    public void loginDDTest1(String[] str){
        driver.get(URL);
        //login
        findElement(By.cssSelector(".fa-user")).click();
        findElement(By.xpath("//li/a[text()='Login']")).click();
        WebElement emailBtn = waitUntilClickable(By.id("input-email"));
        emailBtn.click();
        emailBtn.sendKeys(str[0]);
        WebElement login =
                waitUntilClickable(By.id("input-password"));
        login.sendKeys(str[1]);
        findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(waitUntilVisible(By.xpath("//h2[text() = 'My Account']")).isDisplayed());
        tearDown();

    }

}
