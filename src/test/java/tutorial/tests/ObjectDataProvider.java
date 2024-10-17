package tutorial.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class ObjectDataProvider {
    @Test(dataProvider = "HashMap")
    public void test(Object[] map) {

        System.out.println(Arrays.toString(map));
    }

    @DataProvider(name = "HashMap")
    public Iterator<Object[]> data() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{"email", "vinkotov@example.com"});
        data.add(new Object[]{"password", 1234});
        return data.iterator();

    }
}

