package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExxample {
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)

    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    // test case 1
    @Test(groups="regression")
    public void loginFunctionality(){
        WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginbtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginbtn.click();
    }
    //testcase2
    //verify that password testbox is displayed on the log in pasge
    @Test
    public  void passwordTestBoxVerification(){
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        System.out.println(password.isDisplayed());


    }

}
