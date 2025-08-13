import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Training  {
    public static void main(String[] args) {
    /*    Faker faker = new Faker();
        String loginNegative = faker.animal().name();*/
        String password = "12345";
       Object[][] dataObject = new Object[20][2];
        for(int i = 0; i<20; i++){
            Faker faker = new Faker();
            String loginNegative = faker.animal().name();
            String invalidEmail =loginNegative+"@gmail.com";
            dataObject[i][0] = invalidEmail;
            dataObject[i][1]=password;
        }
        for (Object[] row:dataObject) {
            System.out.println(Arrays.toString(row));
        }

    }
}

