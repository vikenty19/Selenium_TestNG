package tutorial.tests;

import org.testng.annotations.DataProvider;

public class DataProviderExamples {

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
