package pageObjects;

import org.openqa.selenium.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class LandingPage extends BasePage {


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    //  public WebElement getEarnMoney() {
    //       return earnMoney;
    //   }
    //method for click to earn money
    //  public void clickEarnMoney(){
    //      getEarnMoney().click();
    //  }

    public void open() {
        driver.get("https://deens-master.now.sh/");

    }

    //search login button
    public WebElement getLoginButton() {
        var loginButton = wait.until(x -> driver.findElement(By.xpath("//*[@href='/login']")));
        return loginButton;


    }

    //search for signUn button
    private WebElement getSignUpButton() {
        var signUpButton = wait.until(x -> driver.findElement(By.xpath("//*[@href='/register']")));
        return signUpButton;
    }

    //click to login button
    public LoginPage openLoginPage() {
        getLoginButton().click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;

    }

    //click to SignUp button
    public SignUpPage openSignUpPage() {
        getSignUpButton().click();
        SignUpPage signUpPage = new SignUpPage(driver);
        return signUpPage;
    }

    //wait till the moment that avatar be displeed
    private boolean getUserAvatar() {
        return wait.until(x -> driver.findElement(By.cssSelector("[alt='user avatar']")).isDisplayed());
    }

    public boolean isLogged() {
        return getUserAvatar();

    }

    private WebElement getEarnMoneyLink() {
        var earnMoneyLink = driver.findElement(By.xpath("//*[text()='Earn Money']"));
        return earnMoneyLink;
    }

    public EarnMoneyPage openEarnMoneyPage() throws IOException, UnsupportedFlavorException {
        getEarnMoneyLink().click();
        EarnMoneyPage earnMoneyPage = new EarnMoneyPage(driver);
        return earnMoneyPage;
    }

    private WebElement getNYCThumb() {
        return driver.findElement((By.xpath("(//*[text()='New York'])[1]")));
    }

    public DestinationPage openSearchNYCPage() {
        getNYCThumb().click();
        DestinationPage searchNYCPage = new DestinationPage(driver);
        return searchNYCPage;
    }

    private boolean getLandedImage() {
        return wait.until(x -> driver.findElement(By.xpath("//*[@class=' lazyloaded']")).isDisplayed());
    }

    public DestinationPage open(String destination) {

        var city = driver.findElement(By.xpath("//h1[text()='" + destination + "']"));
        city.click();
        return new DestinationPage(driver);
    }

    public boolean isLanded() {
        return getLandedImage();
    }

    public WebElement getBootomButton() throws InterruptedException {
        //elliminate with this code stale element
        boolean staleElement = true;
        WebElement button=null;
        while (staleElement) {
            try {
                button = driver.findElement(By.xpath("//*[text()='Create a Trip & Start Earning']"));
                staleElement = false;

            } catch (StaleElementReferenceException e) {
                staleElement = true;
                Thread.sleep(100);
            }

        }
        return button;
    }
        public void openBottomButton() throws InterruptedException {
        //scroll page till the element
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            getBootomButton().click();
        }

}


