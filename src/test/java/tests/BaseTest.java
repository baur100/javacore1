package tests;

import browserFactory.BrowserFactory;
import enums.BrowserType;
import helpers.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LandingPage;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void startUp(String browserName) throws NoSuchMethodException, NoSuchFieldError {
        BrowserType browserType;
        switch (browserName){
            case "FIREFOX": browserType = BrowserType.FIREFOX;
            break;
            case "CHROME": browserType = BrowserType.CHROME;
            break;
            default: throw new NoSuchFieldError(" NO such browser ");
        }
        var factory = new BrowserFactory();
        driver = factory.createWebDriver(browserType);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException{
        if(result.getStatus()==ITestResult.FAILURE){
            GetScreenshot.capture(driver, result.getName());
        }

        Thread.sleep(1000);
        driver.quit();
    }

    protected LandingPage loginToApp(String username, String password) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open();
        var loginPage = landingPage.openLoginPage();
        return loginPage.login("smarot10","Password_10");
    }
}
