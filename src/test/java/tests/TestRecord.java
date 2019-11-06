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


public class TestRecord {
    private WebDriver driver;
    WebDriverWait wait;
    WebDriverWait longWait;
    Wait<WebDriver> fluentWait;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        longWait = new WebDriverWait(driver, 200);

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

//        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(25,TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(7000);
        driver.quit();
    }

    @Test
    public void clickAviasales(){
        driver.get("https://www.aviasales.ru/");
        driver.findElement(By.id("origin")).sendKeys("NYC");
        driver.findElement(By.id("destination")).sendKeys("LAS");
        driver.findElement(By.xpath("(//*[@class='date-input__input'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='daypicker__day-wrap' and text()=4]")).click();

        driver.findElement(By.xpath("//*[@class='daypicker__day-wrap' and text()=4]")).click();

        driver.findElement(By.xpath("//*[@class='additional-fields --avia of_form_part']")).click();


    }
    @Test
    public void clickDropDown(){
        driver.get("https://deens-master.now.sh/");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//option[@value='pl']")).click();
    }


    @Test
    public void deens_TryToLoginUsingCssSelectors_loginFailedUsingFluentWait() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");

//        fluentWait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.xpath("//*[@href='/login']"));
//            }
//        });

        fluentWait.until(x->x.findElement(By.xpath("//*[@href='/login']")).isEnabled());

        driver.findElement(By.cssSelector("[href='/login']")).click();

        fluentWait.until(x->x.findElement(By.cssSelector("#email")).isDisplayed());
        WebElement id = driver.findElement(By.cssSelector("#email"));
        id.sendKeys("user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("password");

        WebElement login = driver.findElement(By.cssSelector(".green-btn.pl-btn"));
        login.click();
    }
    @Test
    public void deens_TryToLoginUsingCssSelectors_loginFailed() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://deens-master.now.sh/");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[href='/login']"))));
        driver.findElement(By.cssSelector("[href='/login']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email")));
        WebElement id = driver.findElement(By.cssSelector("#email"));
        id.sendKeys("user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("password");

        WebElement login = driver.findElement(By.cssSelector(".green-btn.pl-btn"));
        login.click();
    }

    /*
    * alertIsPresent()
elementSelectionStateToBe()
elementToBeClickable()
elementToBeSelected()
frameToBeAvaliableAndSwitchToIt()
invisibilityOfTheElementLocated()
invisibilityOfElementWithText()
presenceOfAllElementsLocatedBy()
presenceOfElementLocated()
textToBePresentInElement()
textToBePresentInElementLocated()
textToBePresentInElementValue()
titleIs()
titleContains()
visibilityOf()
visibilityOfAllElements()
visibilityOfAllElementsLocatedBy()
visibilityOfElementLocated()*/


    @Test
    public void deens_TryToLoginUsingWrongCredentials_LoginFailedErrorMessageAppear() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(5000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@href='/login']"));
        loginButton.click();

        Thread.sleep(4000);

        WebElement id = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("pl-btn"));

        id.sendKeys("user");
        password.sendKeys("password");
        login.click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElements(By.className("header")).size()==1);
        Assert.assertEquals(driver.findElements(By.className("header")).size(),1);

        var present = false;
        try {
            var x=driver.findElement(By.className("header"));
            present=true;
        }catch (Exception x){
            present=false;
        }
        Assert.assertTrue(present,"Custom error message");
    }

    @Test
    public void searchTripIn() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");
        Thread.sleep(2000);
        WebElement searchTrip = driver.findElement(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']/*"));
        searchTrip.clear();
        searchTrip.sendKeys("New York,  New York");
        searchTrip.sendKeys(Keys.ENTER);
    }
    @Test
    public void searchInGoogLe_searchingForACar_CarFound() {
        driver.get("http://google.com/");

            WebElement searchBox = driver.findElement(By.xpath("//*[@maxlength='2048']"));
            searchBox.sendKeys("Car");

            Assert.assertEquals(searchBox.getAttribute("value"),"Car");

            WebElement searchButton = driver.findElement(By.xpath("//*[@name='btnK']"));

            Assert.assertTrue(searchButton.isDisplayed());



//        try{
//            WebElement searchBox = driver.findElement(By.xpath("//*[@maxlength='2048']"));
//            searchBox.sendKeys("Car");
//
//            List<WebElement> searchButtons = driver.findElements(By.xpath("//*[@name='btnK']"));
//            searchButtons.forEach(button->{
//                if(button.isDisplayed()){
//                    button.click();
//                }
//            });
//        }catch(Exception x){
//
//        }


//        searchBox.sendKeys(Keys.RETURN);

//        WebElement searchButton = driver.findElement(By.xpath("(//*[@name='btnK'])[1]"));
//        searchButton.click();

    }

    @Test
    public void deens_ClickLoginButton_LoginPageOpened() throws InterruptedException {
        //Arrange
        driver.get("https://deens-master.now.sh/");

        //Act
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();

        //Assert
        Thread.sleep(2000);
        WebElement loginHeader = driver.findElement(By.xpath("//*[@class='login-header']"));
        String text=loginHeader.getText();
        Assert.assertEquals(text,"Log-in to your account");
    }

    // //*[@class='login-img-content']
    // //*[text()='Plan your next trip with us!']
    // //*[contains(text(),'next trip')]

    @Test
    public void openUrl_TryToOpenDeens_GoogleOpened()  {
        driver.get("https://google.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title,"Deens, plan my trip!", "Expected title is wrong");
    }

    @Test
    public void openUrl_TryToOpenDeens_BingOpened(){
        driver.get("https://Bing.com/");
        var title = driver.getTitle();
        Assert.assertEquals(title,"Deens, plan my trip!", "Expected title is wrong");
    }

    @Test
    public void openUrl_TryToOpenDeens_DeensOpened(){
        driver.get("https://deens-master.now.sh/");
        var title = driver.getTitle();
        Assert.assertEquals(title,"Deens, plan my trip!", "Expected title is wrong");
    }

    @Test
    public void openUrl_TryToOpenDeensCheckUrl_DeensOpened(){
        driver.get("https://deens-master.now.sh/");
        var url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://deens-master.now.sh/", "Expected URL is wrong");
    }

}
