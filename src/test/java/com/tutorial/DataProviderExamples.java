package com.tutorial;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderExamples {


    @DataProvider(name = "LoginDataSupplier")
    public Object[][] credentialsSupplier(){
          String password = "12345";
          Object[][] dataObject = new Object[20][2];
        for(int i = 0; i<20; i++){
            Faker faker = new Faker();
            String loginNegative = faker.animal().name();
            String invalidEmail =loginNegative+"@gmail.com";
            dataObject[i][0] = invalidEmail;
            dataObject[i][1]=password;
        }
       /* Object[][] data = {{"amotooricap@gmail.com","12345"},
                {"amotooricap8@gmail.com","12345"},
                {"amotooricap6@gmail.com","12345"}};
        return data;*/
        return dataObject;
    }

    @DataProvider
    public Object[][] setOfData() {
        Object[][] data = {{"vv@mail.ru", "megadelta"}, {"amotooricap3@gmail.com", "12345"}
                , {"amotooricap7@gmail.com", "12345"}};
        return data;
    }
    @DataProvider
    public Object[] setOfData1(){
        Object[][]data1 = {{"VV","RR"},{"tt","MM"}};
        return data1;

    }
}
