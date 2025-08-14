package com.tutorial;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataProviderExamples {


    @DataProvider(name = "LoginValidEmailSupplier")
    public Object[][] validEmailsSupplier() {
        String password = "12345";
        int count = 20;
        Object[][] dataObject = new Object[count + 1][2];
        for (int i = 0; i < 20; i++) {
            Faker faker = new Faker();
            String loginNegative = faker.color().name();
            String invalidEmail = loginNegative + "@gmail.com";
            dataObject[i][0] = invalidEmail;
            dataObject[i][1] = password;
        }//empty email added
        dataObject[count][0] = "";
        dataObject[count][1] = password;

        return dataObject;
    }

    @DataProvider(name = "TimeStampEmail")
    public Object[] arrayOfEmails() {
        Date data = new Date();
//create Object[] == string[];
        Object[] dataEmail = new Object[10];
        for (int i = 0; i < 10; i++) {
            String j = Integer.toString(i);
            String randomGmail = j + data.toString().replace(" ", "_").replace(":", "_").substring(8) + "@gmail.com";
            dataEmail[i] = randomGmail;
        }
        return dataEmail;
    }

    @DataProvider
    public Object[][] credentialsArraySupplier() {

        Object[][] data = {{"amotooric12@gmail.com", "12345"},
                {"amotoicap8@gmail.com", "12345"},
                {"amotooooricap61@gmail.com", "12345"}};
        return data;

    }

    @DataProvider
    public Object[][] setOfData() {
        Object[][] data = {{"vv@mail.ru", "megadelta"}, {"amotooricap3@gmail.com", "12345"}
                , {"amotooricap7@gmail.com", "12345"}};
        return data;
    }

    @DataProvider
    public Object[] setOfData1() {
        Object[][] data1 = {{"VV", "RR"}, {"tt", "MM"}};
        return data1;

    }
    @DataProvider(name= "ListOfObjects[]")
    public Iterator<Object[]> iteratorData(){
        List<Object[]> list=new ArrayList<>();

        list.add(new Object[]{"vv@mail.ru", "megadelta"});
        list.add(new Object[]{"amotooricap3@gmail.com", "12345"});
        list.add(new Object[]{"amotooricap7@gmail.com", "12345"});
        return list.iterator();
    }
}
