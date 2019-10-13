package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SignIn {
    private WebDriver driver;

    @BeforeMethod
    public void sratUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver 2");

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(7000);
        //destroi the browser

        driver.quit();
    }

    @Test
    public void searchInGoogle_searchingForACar_CarFouded () {
        try{

        //founf the field
        WebElement searchBox = driver.findElement(By.xpath("//*[@maxlength='2048']"));

        //input ord to this field

        searchBox.sendKeys("Car");
        Assert.assertEquals(searchBox.getAttribute("value"),"Car");
        //found search buttom

        //WebElement seachButton = driver.findElement(By.xpath("(//*name='btnK'])[1]"));

        //click to the buttom search
        //seachButton.click();

        //click to the enter
        // searchBox.sendKeys(Keys.RETURN);

        List<WebElement> searchButtons = driver.findElements(By.xpath("//*name='btnK']"));
        searchButtons.forEach(button -> {
            if (button.isDisplayed()) {
                button.click();
            }
        });
    }catch(Exception x)

    {
    }




    }

    @Test
    public void deens_ClickSignUpButton_SignUpPageOpened() throws InterruptedException {

        //Arrange

        //open page deens
        driver.get("https://deens-master.now.sh/");

        //Act

        //found button "Login"
        WebElement sighUpButton = driver.findElement(By.xpath("//*[@href='/register']"));
        sighUpButton.click();

        //Assert
        Thread.sleep(2000);

        //Assert that e are on the good page

        var url = driver.getCurrentUrl();
        //Assert cont 3 part: actualm, expected, error message

        Assert.assertEquals(url, "https://deens-master.now.sh/register", "Expected url is wrong!");

        WebElement createAccount = driver.findElement(By.xpath("//*[contains(text(),'Create an account')]"));
        //retrive text from the founded previously eb element
        String text = createAccount.getText();
        Assert.assertEquals(text,"Create an account");

    }


}