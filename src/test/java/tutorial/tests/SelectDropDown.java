package tutorial.tests;

import com.tutorial.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropDown extends BaseTest {
    @Test
    public void dropDownWait() {
        BasePage basePage = new BasePage(driver);
        driver.get(url);
        driver.findElement(By.cssSelector("button.dropbtn")).click();
        WebElement gmail = basePage.waitUntilClickable(By.linkText("Gmail"));
        gmail.click();
        wait.until(ExpectedConditions.urlContains("google"));
        Assert.assertTrue(driver.getTitle().contains("Gmail"));
    }

    @Test
    public void multiSelectOption() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        driver.get("https://letcode.in/dropdowns");
        By fruits = By.id("fruits");
        By languages = By.id("lang");
        By countries = By.id("country");
        By heros = By.id("superheros");
        basePage.selectOptionByText("Orange", fruits);
        basePage.selectOptionByIndex("4", languages);
        basePage.selectOptionByValue("Peru", countries);
        Thread.sleep(2000);
        basePage.selectOptionToPick(heros, "value", "ca");
        basePage.selectOptionToPick(countries, "index", "0");
        Thread.sleep(3000);


    }

}
