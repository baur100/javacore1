package tests;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Parameter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestRecord {
    private WebDriver driver;

    //this we create variable for explicit wait
    WebDriverWait wait;
    WebDriverWait longWait;
    //Wait it s interface generic - work with WebDriver and can work with AppiumDriver and others
    Wait<WebDriver> fluentWait;


    @BeforeMethod
    public void sratUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver 2");

        driver = new ChromeDriver();
        // ***** on some companies put ons implisit wait there *******
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //разновидности implisit wait
        //ждем пока загрузится вся страница - максимум 20 сек
        //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        //это для асинхронного кода ждем опка загрузится скрипт(джава скрипт или Си шарп)
        //driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);

        //explisit wait
        //after we need put it only on place where we need it
        wait = new WebDriverWait(driver,20);
        //можно использовать несколько вейтов разных по продолжительности и использовать их в зависимости от ситуации
        //например более длительный для загрузки файлов
        longWait = new WebDriverWait(driver,200);
        //initialization of one Interface Wait
        fluentWait = new FluentWait<WebDriver>(driver)
                //настройки ожиданий
                .withTimeout(Duration.ofSeconds(30))
                //оплределяем сколько миллисекунт между поисками
                .pollingEvery(Duration.ofMillis(200))
                // в течении 30 секунд игнорируем сообщения об ошибках
                .ignoring(NoSuchElementException.class);
        //можно игнорировать несколько ошибок - сделать несколько игнорингов

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(7000);
        //destroi the browser

        driver.quit();
    }


    @Test
    public void deens_TryToLoginUsingCssSelectors_loginFailedUsingFluentWait() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");

        //fluent Wait
        fluentWait.until(x->x.findElement(By.xpath("//*[@href='/login']")).isEnabled());

        driver.findElement(By.cssSelector("[href='/login']")).click();

        fluentWait.until(x->x.findElement(By.cssSelector("#email")).isDisplayed());


        driver.findElement(By.cssSelector("#email")).sendKeys("user");


        WebElement password = driver.findElement((By.cssSelector("#password")));
        password.sendKeys("password");
        //указываем частичное название класса
        WebElement login = driver.findElement(By.cssSelector(".green-btn.pl-btn"));
        login.click();

    }

    @Test
    public void deens_TryToLoginUsingCssSelectors_loginFailed() throws InterruptedException {

        //implicit wait не явный
        //запускается после запуска драйвера но перед открытием страницы
        //между запросами у него проходит полсекунды перед каждым поиском элемента
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://deens-master.now.sh/");



        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[href='/login']"))));
        driver.findElement(By.cssSelector("[href='/login']")).click();



        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#email"))));
        driver.findElement(By.cssSelector("#email")).sendKeys("user");


        WebElement password = driver.findElement((By.cssSelector("#password")));
        password.sendKeys("password");
        //указываем частичное название класса
        WebElement login = driver.findElement(By.cssSelector(".green-btn.pl-btn"));
        login.click();

    }
    /*
    Expected conditions : https://www.guru99.com/implicit-explicit-waits-selenium.html
    alertIsPresent()
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
visibilityOfElementLocated()

     */

    @Test
    public void searchTreepIn() throws InterruptedException {
        driver.get("https://deens-master.now.sh/");

        //explicit ait - контретное место для конкретного элемента
        Thread.sleep(2000);
        //находим родителя и потом какого угодно его ребенка
        WebElement searchTTrip = driver.findElement(By.xpath("//*[style=\'overflow: hidden; padding: 2px 0px;\']/*"));
        //находим поле, чистим, посылаем туда значение, и нажимаем энтер
        searchTTrip.clear();
        searchTTrip.sendKeys("New York, New York");
        searchTTrip.sendKeys((Keys.ENTER));
    }

    @Test
    public void deens_TryToLoginUsingrongCredentials_LoginFailed() throws InterruptedException {
        //login ith wrong credentials

        driver.get("https://deens-master.now.sh/");

        Thread.sleep(2000);
        WebElement loginButtom = driver.findElement(By.linkText("Login"));
        loginButtom.click();

        Thread.sleep(4000);
        WebElement id=driver.findElement(By.id("email"));
        WebElement password = driver.findElement((By.name("password")));
        //указываем частичное название класса
        WebElement login = driver.findElement(By.className("pl-btn"));

        id.sendKeys("user");
        password.sendKeys("password");
        login.click();

        Thread.sleep(2000);

        //проверяем если на странице есть сообщение об ошибке

       // Assert.assertTrue(driver.findElements(By.className("header")).size()!=0);
        Assert.assertEquals(driver.findElements(By.className("header")).size(),1);




    }

    @Test
    public void deens_ClickLoginButton_LoginPageOpened() throws InterruptedException {

        //Arrange

        //open page deens
        driver.get("https://deens-master.now.sh/");

        //Act

        //found button "Login"
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();

        //Assert
        Thread.sleep(2000);

        //Assert that e are on the good page

        WebElement loginHeader = driver.findElement(By.xpath("//*[@class='login-header']"));
        //retrive text from the founded previously eb element
        String text = loginHeader.getText();
        Assert.assertEquals(text,"Log-in to your account");




    }

    @Test
    public void openUrl_TryToOpenDeens_DeensOpened() {


        //open the page

        driver.get("https://deens-master.now.sh/");

        //get title of the page
        var title = driver.getTitle();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong!");


    }

    @Test
    public void openUrl_TryToOpenDeens_BeengOpened() {


        //open the page

        driver.get("https://Beeng.com/");

        //get title of the page
        var title = driver.getTitle();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong!");
    }

    @Test
    public void openUrl_TryToOpenDeens_GoogleOpened() {


        //open the page

        driver.get("https://Google.com/");

        //get title of the page
        var title = driver.getTitle();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(title, "Deens, plan my trip!", "Expected title is wrong!");
    }
    @Test
    public void assertUrl_TryToOpenDeens_DeensOpened() {


        //open the page

        driver.get("https://deens-master.now.sh/");

        //get title of the page
        var url = driver.getCurrentUrl();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(url, "https://deens-master.now.sh/", "Expected url is wrong!");
    }
    @Test
    public void assertUrl_TryToOpenAnnaSenaArt_AnnaSenaArtOpened() {


        //open the page

        driver.get("https://annasena.art");

        //get title of the page
        var url = driver.getCurrentUrl();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(url, "https://annasena.art/", "Expected url is wrong!");
    }
    @Test
    public void assertTitle_TryToOpenAnnaSenaArt_AnnaSenaArtOpened() {


        //open the page

        driver.get("https://annasena.art");

        //get title of the page
        var title = driver.getTitle();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(title, "Anna Sena Art", "Expected title is wrong!");
    }
    @Test
    public void getPageSource_TryToOpenAnnaSenaArt_AnnaSenaArtOpened() {


        //open the page

        driver.get("https://annasena.art");

        //get title of the page
        var pageSource = driver.getPageSource();
        //Assert cont 3 part: actualm, expected, error message

        System.out.println("page source "+pageSource);
    }

    @Test
    public void assertTitle_TryToOpenHomeAay_HomeAayOpened() {


        //open the page

        driver.get("https://www.homeaway.co.uk");

        //get title of the page
        var title = driver.getTitle();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(title, "HomeAway.co.uk | Book your holiday lettings: villas, apartments, cottages", "Expected title is wrong!");
    }
    @Test
    public void assertUrl_TryToOpenHomeAay_HomeAayOpened() {


        //open the page

        driver.get("https://www.homeaway.co.uk");

        //get title of the page
        var url = driver.getCurrentUrl();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(url, "https://www.homeaway.co.uk/", "Expected url is wrong!");
    }



}