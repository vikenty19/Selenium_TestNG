import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Training  {
    public static void main(String[] args) {
         String password = "12345";
         int count = 20;//number of row
       Object[][] dataObject = new Object[count+1][2];
        for(int i = 0; i<count; i++){
            Faker faker = new Faker();
            String loginNegative = faker.animal().name();
            String invalidEmail =loginNegative+"@gmail.com";
            dataObject[i][0] = invalidEmail;
            dataObject[i][1]=password;
        }
       dataObject[count][0]="";
       dataObject[count][1]=password;
        for (Object[] row:dataObject) {
            System.out.println(Arrays.toString(row)+"  "+count);
        }

    }
}

