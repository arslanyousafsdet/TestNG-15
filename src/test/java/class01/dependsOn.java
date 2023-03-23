package class01;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void Login(){
        System.out.println("i am here ");}
        @Test(dependsOnMethods = {"Login"})
        public void dashBoardVerification() {
            System.out.println("after login i am verifying dashboards");
        }
    }

