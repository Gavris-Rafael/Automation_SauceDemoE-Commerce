package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static constants.URLs.*;


public class BaseTests {

    public ChromeDriver driver;
    public WebDriverWait wait;

    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckOutFirstStep checkoutFirstStepPage;
    protected OverviewPage overviewPage;
    protected CompletePage completePage;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("incognito");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        goHome();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutFirstStepPage = new CheckOutFirstStep(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get(LOGIN_URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void tearDown() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.quit();
    }
}
