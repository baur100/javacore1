package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UnitTest {
    @DataProvider(name="test1")
    public static Object[][]sumNumbers(){
        return new Object[][]{{2,5,7},{6,10,16},{19,2,21},{15,4,19},{12,3,15}};


    }
    @DataProvider(name="test2")
    public static Object[][]sumStrings() {
        return new Object[][]{{"2", "5", "25"}, {"aa", "bb", "aabb"}, {"w", "w", "www"}};
    }

    @Test(dataProvider = "test1")
    public void testPrimeNumberChecker(int a, int  b, int sum) {
        Assert.assertEquals(a+b,sum);
    }
    @Test(dataProvider = "test2")
    public void testPrimeNumberChecker(String a, String  b, String sum) {
        Assert.assertEquals(a+b,sum);
    }

}
