package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProvider1 extends BasePage {

    @Test
    public void loginDDTest(){
        driver.get(URL);
        //login
       findElement(By.cssSelector(".fa-user")).click();
       findElement(By.xpath("//li/a[text()='Login']")).click();
        WebElement emailBtn = waitUntilClickable(By.id("input-email"));
        emailBtn.click();
        emailBtn.sendKeys(email);
        WebElement login =
                waitUntilClickable(By.id("input-password"));
        login.sendKeys(password);
        findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(waitUntilVisible(By.xpath("//h2[text() = 'My Account']")).isDisplayed());
        tearDown();

    }
}
