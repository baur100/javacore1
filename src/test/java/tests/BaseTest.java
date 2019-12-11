package tests;

import browserFactory.BrowserFactory;
import enums.BrowserType;
import helpers.GetScreenShot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LandingPage;

public class BaseTest {
    WebDriver driver;
    protected Logger logger;

    @BeforeMethod
    @Parameters({"browser"})



    public void startUp(String browserName) throws NoSuchMethodException, NoSuchFieldError {
        logger = LogManager.getLogger();

        BrowserType browserType;
        switch (browserName){
            case "FIREFOX": browserType = BrowserType.FIREFOX;
                break;
            case "CHROME": browserType =BrowserType.CHROME;
                break;
            default: throw new NoSuchFieldError(" No such browser ");
        }

        var factory = new BrowserFactory();
        driver = factory.createWebDriver(browserType);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        //if test don t pass - create one screenshot and safe the name of test
        if(result.getStatus()==ITestResult.FAILURE){
            GetScreenShot.capture(driver, result.getName());
        }

        Thread.sleep(8000);
        driver.quit();
    }
    protected LandingPage logintoApp(String user, String password) {
        var landingPage = new LandingPage(driver);

        landingPage.open();

        //user is redirected to the login page

        var loginPage = landingPage.openLoginPage();

        //fill the field and login
        return loginPage.loginGood("useras", "mailinator");
        //return landingPage;

    }


}
