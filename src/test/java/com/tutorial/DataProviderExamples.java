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
          Object[][] dataObject = new Object[25][2];
        for(int i = 0; i<20; i++){
            Faker faker = new Faker();
            String loginNegative = faker.animal().name();
            String invalidEmail =loginNegative+"@gmail.com";
            dataObject[i][0] = invalidEmail;
            dataObject[i][1]=password;
        }

        return dataObject;
    }
    @DataProvider
    public Object[][] credentialsArraySupplier(){

        Object[][] data = {{"amotooric12@gmail.com","12345"},
                {"amotoicap8@gmail.com","12345"},
                {"amotooooricap61@gmail.com","12345"}};
        return data;

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
