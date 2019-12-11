package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DestinationPage extends BasePage{
    public DestinationPage(WebDriver driver)
    {
        super(driver);
    }
//    private boolean getNYTumb() {
//        return wait.until(x -> driver.findElement(By.xpath("//*[text()='New York']")).isDisplayed());
//    }
//
//    public boolean nYCisPresent() {
//        return getNYTumb();
//    }
//
//
//
//    public int getNYCTumbs(){
//        int nYCElements=wait.until(x->driver.findElements(By.xpath("//*[contains(@class, 'Trip__LinkWrapper')]")).size());
//        return nYCElements;
//    }
    private By getTripByXpath(){
        return By.xpath("//*[contains(@class, 'Trip__LinkWrapper')]");
        
    }
    public List<WebElement> getTrips(){
        wait.until(x->driver.findElement(getTripByXpath()));
        return driver.findElements(getTripByXpath());
    }


}
