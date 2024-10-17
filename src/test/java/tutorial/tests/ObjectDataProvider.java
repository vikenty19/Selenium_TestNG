package tutorial.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class ObjectDataProvider {
    @Test(dataProvider = "HashMap")
    public void test(Object[] map) {
  //jagged array - different size of every object
  //    System.out.println(Arrays.toString(map));
        //another way
        for (int i = 0; i < map.length ; i++) {
            System.out.print (map[i]+"  ");

        }
        System.out.println();
        System.out.println("_____________");
    }


    @DataProvider(name = "HashMap")
    public Iterator<Object[]> data() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"email", "vinkotov@example.com"});
        data.add(new Object[]{"password", 1234});
        data.add(new Object[]{56});
        return data.iterator();

    }
}

