package tests.business;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    /* Shared Test Data*/
    // login data
    /*  Staging */
    public String ENV_URL = "https://stg-business.bosta.co";
    public String BUSINESS_EMAIL = "selenium.883@gmail.com";
    public String BUSINESS_PASSWORD = "12345678";
    /* production */
   /* String envURL = "https://business.bosta.co";
    String businessEmail = "hania.helmi@bosta.co";
    String businessPassword = "111111111";*/

    /* *************** */

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void stopDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    // take screenshot when test case fail and add it in the screenshots folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed! - Taking screenshots..");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

}
