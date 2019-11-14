package tests;

import listeners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DestinationPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class PageObjectTests extends BaseTest {

    //homework 14
    @Test
    public void scrollPage(){
        logger.info("scrollPage started");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open();
        landingPage.openBottomoButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://deens-master.now.sh/new/trip");
        logger.info("scrollPage finished");


    }

    //homework13
    @Test
    public void checkNumberOfTripsInNewYork(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open();
        DestinationPage destinationPage = landingPage.open("New York");
        var trips = destinationPage.getTrips();

        Assert.assertEquals(trips.size(),6);
    }


    //homework 11(earn money) with Baurzhan
    @Test
    public void getReferenceCode() throws IOException, UnsupportedFlavorException, InterruptedException {
        var landingPage = loginTOApp("smarot10", "Password_10");
        Thread.sleep(3000);
        var earnMoney = landingPage.openEarnMoneyPage();
        var  textFromField = earnMoney.getCodeField().getAttribute("value");
        var textFromClipboard = earnMoney.getTextFromClipboard().split("=")[1];

        Assert.assertEquals(textFromField,textFromClipboard);

    }



    @Test
    public void clickEarnMoney(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open();
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)

    public void loginTOApp() throws InterruptedException {
        var landingPage = new LandingPage(driver);
        landingPage.open();
        LoginPage loginPage = landingPage.openLoginPage();
        loginPage.login("user", "password");


    }




}
