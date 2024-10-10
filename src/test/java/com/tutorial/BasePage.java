package com.tutorial;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected  WebDriver driver;
  protected WebDriverWait wait;
public String generateLogin() {
  Faker faker = new Faker();
  String loginNegative = faker.animal().name();
  return loginNegative;
}
}
