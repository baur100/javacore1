package tests;


import listeners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DestinationPage;
import pageObjects.LandingPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static helpers.RandomStringGenerator.randomEmail;
import static helpers.RandomStringGenerator.randomString;

public class SecondPageObjectTests extends BaseTest {

    @Test
    public void secondClickEarnMoney() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.open();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void secondLoginToApp() throws InterruptedException {
        //create landing page and give it driver
        var landingPage = new LandingPage(driver);
        //open landing page
        landingPage.open();

        //user is redirected to the login page
        var loginPage = landingPage.openLoginPage();

        //Thread.sleep(3000);
        //fill the field and login
        loginPage.login("user", "passord");
    }

    @Test
    public void secondRegisterNewUser_LoggedAsNewUser() {
//        Random randomSelector = new Random();
//        var randomNumber = randomSelector.nextInt(10000);
        var landingPage = new LandingPage(driver);
        //open landing page
        landingPage.open();

        //user is redirected to the sign up page
        var signUpPage = landingPage.openSignUpPage();

        //generate ramdon user and email
        String username = randomString(10);
        String password = randomString(12);
        String email = randomEmail();

        landingPage = signUpPage.registerNewUser(username, email, password);

        //fill the fields on the shign up page

        //   signUpPage.signUp("user"+randomNumber,"email"+randomNumber+"@mailinator.com","password21");

        // asser that we are loged
        var logged = landingPage.isLogged();
        //verify that we have avatar at the page is true

        Assert.assertTrue(logged);


    }

    @Test
    public void secondLoginUser_copyReferralLink() throws IOException, UnsupportedFlavorException {
        var landingPage = logintoApp("useras","mailinator");

        Assert.assertTrue(landingPage.isLogged());

        //open page Earn money

        var earnMoneyPage = landingPage.openEarnMoneyPage();

        //вытаскиваем значение атрибута валуе
        String textFromField = earnMoneyPage.getCodeField().getAttribute("value");
        //нажать кнопку и вытащить инфо из клипборда
        //разбиваем стринг по = и берет вторую часть
        var textFromClipBoard = earnMoneyPage.getTextFromClipBoard().split("=")[1];
        //сравниваем текст валуе и из клипборда
        Assert.assertEquals(textFromField,textFromClipBoard);

    }
    @Test
    public void secondCheckNumberOfTripsNewYork(){
       // var landingPage = logintoApp("useras","mailinator");
        var landingPage = new LandingPage(driver);
        //open landing page
        landingPage.open();
        Assert.assertTrue(landingPage.isLanded());


        //search element Thumbs NYC and go to search page
       // var searchNYCPage = landingPage.openSearchNYCPage();
        //Assert.assertTrue(searchNYCPage.nYCisPresent());

       // Assert.assertEquals(searchNYCPage.getNYCTumbs(),6);

        DestinationPage destinationPage = landingPage.open("New York");
        var trips = destinationPage.getTrips();
        Assert.assertEquals(trips.size(),6);

    }
    @Test
    public void testSumm(){

    }


    }





