package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGannotations {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Iam before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
    @Test(groups="regression")
    public void aFirstTestCase(){
        System.out.println("i am a first test case ");
    }
    @Test
    public void bSecondTestCase(){
        System.out.println("Iam the second test case");
    }
    @Test
    public void cThirdTestCase(){
        System.out.println("This is third test case");
    }

}
