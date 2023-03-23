package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    //preconditions
    public static WebDriver driver;
    @BeforeMethod

    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    //post conditions
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    //testcase
//    enter the username:Admin
    //enter the password: AbracaDabara
    //click log in button
    //varify that the messgae invild credentiols is displayed
    @Test
    public void invildCredentials(){
        // locate the WebElement user name and send keys


        WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");

        //locate the webElement password and send keys
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("abrreaca dabera");

        // locate login button and click  log in
        WebElement loginbtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginbtn.click();
        // verify the message
        WebElement error= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg=error.getText();
        // check if the eroor  message is correct
        String expectedError="Invalid credentials";
        //just showing the examples
       /* if(errorMsg.equalsIgnoreCase(expectedEroor)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }*/
        Assert.assertEquals(expectedError,errorMsg);
        System.out.println("i am here ");
        // finind the element again while other one dicorded after clicking on log in button becauseDom Refresh
        password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        //password text box is displayed
        boolean pswrdDisplayed=password.isDisplayed();
        //verify that text box is displayed
        Assert.assertTrue(pswrdDisplayed);
    }
}
