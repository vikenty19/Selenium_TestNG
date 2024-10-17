package tutorial.tests;

import org.testng.annotations.DataProvider;

public class DataProviderExamples {

    @DataProvider
    public Object[][] setOfData() {
        String[][] data = {{"vv@mail.ru", "megadelta"}, {"amotooricap3@gmail.com", "12345"}
                , {"amotooricap7@gmail.com", "12345"}};
        return data;
    }
}
