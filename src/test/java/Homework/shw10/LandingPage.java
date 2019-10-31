package Homework.shw10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LandingPage {
    private WebDriver driver;
    Wait<WebDriver> wait;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);
    }

    public void open() {
        driver.get("https://deens-master.now.sh/");
    }

    public WebElement getSignupButton(){
        var signupButton = wait.until(x->driver.findElement(By.xpath("//*[@href='/register']")));
        return signupButton;
    }

    public SignupPage openSignupPage() {

        getSignupButton().click();
        SignupPage signupPage = new SignupPage(driver);
        return signupPage;
    }

}