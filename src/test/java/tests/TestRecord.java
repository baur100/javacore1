package tests;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestRecord {
    private WebDriver driver;
    WebDriverWait wait;  // explicit wait -  expected conditions
    WebDriverWait longWait;// explicit wait -  expected conditions
    Wait<WebDriver> fluentWait;


    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);// explicit wait -  expected conditions
        longWait = new WebDriverWait(driver, 200);// explicit wait -  expected conditions

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(7000);
        driver.quit();

    }

    //lesson 18 drop down menu
    @Test
    public void deens_clickDropDown(){
        driver.get("https://deens-master.now.sh/");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//option[@value='pl']")).click();
    }

    //lesson 18 drop down menu
    @Test
    public void clickAviasales(){
        driver.get("https://www.aviasales.com/");
        driver.findElement(By.id("origin")).clear();
        driver.findElement(By.id("origin")).sendKeys("NYC",Keys.RETURN);
        driver.findElement(By.id("destination")).sendKeys("LAS");
        driver.findElement(By.id("departDate")).click();
        driver.findElement(By.xpath("//*[@class='daypicker__day-wrap' and text()=13]")).click();
        driver.findElement(By.xpath("//*[@class='return-clear']")).click();
        driver.findElement(By.xpath("//*[@class='additional-fields --avia of_form_part']")).click();



    }

    //lesson 9 (Fluent wait)
    @Test
    public void deensWait_tryToLoginUsingCsscelectors_LoginFailedUsingFluentWait() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");


        //bad written  fluent wait
//        fluentWait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver){
//                return driver.findElement(By.xpath("//*[@href='/login']"));
//            }
//        });

        //good written fluent wait
        fluentWait.until(x->driver.findElement(By.xpath("//*[@href='/login']")).isEnabled());

        driver.findElement(By.cssSelector("[href='/login']")).click();

        fluentWait.until(x->x.findElement(By.xpath("//*[@id='email']")).isDisplayed());
        WebElement id = driver.findElement(By.xpath("//*[@id='email']"));
        id.sendKeys("user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("password");

        WebElement login = driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn"));
        login.click();

    }

    //lesson 8 (Waits)
    @Test
    public void deensWait_tryToLoginUsingCsscelectors_LoginFailed() throws InterruptedException {
 //       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://deens-master.now.sh/");

//        Explicit wait - способ №1 by Web Element
        WebElement loginButton = driver.findElement(By.cssSelector("[href='/login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

//        Explicit wait - - способ №2 by locator
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email")));
        WebElement id = driver.findElement(By.cssSelector("#email"));
        id.sendKeys("user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("password");

        WebElement login = driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn"));
        login.click();

    }

    //lesson 7
    @Test
    public void deens_tryToLoginUsingCsscelectors_LoginFailed() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.cssSelector("[href='/login']"));
        loginButton.click();
        Thread.sleep(4000);

        WebElement id = driver.findElement(By.cssSelector("#email"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement login = driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn"));

        id.sendKeys("user");
        password.sendKeys("password");
        login.click();

        Thread.sleep(4000);
    }
    //SHW7
    @Test
    public void deens_doingHomewrok7() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.cssSelector("[href='/login']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement emailField =  driver.findElement(By.cssSelector("#email"));
        emailField.sendKeys("user");
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("password");
        WebElement login = driver.findElement(By.cssSelector("[data-testid='loginSubmit']"));
        login. click();
        Thread.sleep(4000);

        WebElement logoDeens = driver.findElement(By.cssSelector("[src='/logo.svg']"));
        logoDeens.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("[href*='register']"));
        signUpButton.click();
        Thread.sleep(2000);
        WebElement emailField1 =  driver.findElement(By.cssSelector("#email"));
        emailField1.sendKeys("user");
        WebElement passwordField1 = driver.findElement(By.cssSelector("#password"));
        passwordField1.sendKeys("password");
        WebElement login1 = driver.findElement(By.cssSelector("[data-testid='loginSubmit']"));
        login1. click();
        Thread.sleep(4000);

        WebElement signUpDontHaveAccount = driver.findElement(By.cssSelector(".login-q-text>*:first-child"));
        signUpDontHaveAccount.click();

        WebElement signUpHeader = driver.findElement(By.cssSelector(".login-header"));
        var note = signUpHeader.getText();
        Assert.assertEquals(note, "Create an account");

        Thread.sleep(5000);




    }

    @Test
    public void deens_searchTripIn() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(2000);

        WebElement searchTrip = driver.findElement(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']/*"));
        searchTrip.clear();
        searchTrip.sendKeys("New York, New York");
        searchTrip.sendKeys(Keys.ENTER);




    }
    @Test
    public void deens_TryToLoginUsingWrongCredentials_LoginFailed() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        Thread.sleep(5000);

        WebElement id = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("pl-btn"));

        id.sendKeys("user");
        password.sendKeys("password");
        login.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.className("header")).size()!=0);

    }
    //SHW6
//    Используя WebElement email - как точку отсчета - вычислите локаторы для вебэлементов пароль и логин.
//    Запустите тест deens_TryToLoginUsingWrongCredentials_LoginFailedErrorMessageAppear()
//    используя эти локаторы


    @Test
    public void deens_TryToLoginUsingWrongCredentials_LoginFailedErrorMessageAppear() throws InterruptedException {
        driver.get("https://deens-master.now.sh");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@href='/login']"));
        loginButton.click();

        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//*[@id='email']"));
        userName.sendKeys("user");

        WebElement password = driver.findElement(By.xpath("//*[@id='email']/parent::*/parent::*/following-sibling::*/*/*[1]"));
        password.sendKeys("somepassword");

        WebElement login = driver.findElement(By.xpath("//*[@id='email']/parent::*/parent::*/following-sibling::*/following-sibling::*"));
        login.click();

        Thread.sleep(2000);

        WebElement loginNote = driver.findElement(By.xpath("//*[@class='header']"));
        var text2 = loginNote.getText();
        Assert.assertEquals(text2, "Cannot login");

        Thread.sleep(5000);




    }

    @Test
    public void searchInGoogle_searchingForACar(){

        //Arrange
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@maxlength]"));
        searchBox.sendKeys("Car");

        WebElement searchButton = driver.findElement(By.xpath("//*[@name='btnK']"));


//        List<WebElement> searchButtons = driver.findElements(By.xpath("//*[@name='btnK']"));
//        searchButtons.forEach(button->{
//            if(button.isDisplayed()){
//                button.click();
//            }
//        });

//        searchBox.sendKeys(Keys.RETURN);

//        WebElement searchButton = driver.findElement(By.xpath("(//*[@name='btnK'])[2]"));
//        searchButton.click();




    }

    @Test
    public void deens_clickLoginButton_LoginPageOpened() throws InterruptedException{
        //Arrange
        driver.get("https://deens-master.now.sh");

        //Act
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();

        //Assert
        Thread.sleep(2000);
        WebElement loginHeader =  driver.findElement(By.xpath("//*[@class='login-header']"));
        String text = loginHeader.getText();
        Assert.assertEquals(text, "1Log-in to your account");

        // //*[@class='login-img-content']
        // Plan your next trip with us!
        // //*[contains(text(),'next trip')]


    }
    @Test

    public void openUrl_TryToOPenDeens_GoogleOpened()  {
        driver.get("https://google.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong");


    }
    @Test
    public void openUrl_TryToOPenDeens_BingOpened(){
        driver.get("https://bing.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong");

    }

    @Test
    public void openUrl_TryToOPenDeens_DeensOpened(){
        driver.get("https://deens-master.now.sh");
        var title = driver.getTitle();
        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong");

    }
    @Test
    public void openUrl_TryToOPenDeensCheckUrl_DeensOpened (){
        driver.get("https://deens-master.now.sh");
        var url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://deens-master.now.sh/", "Expected URL is wrong");

    }


}
