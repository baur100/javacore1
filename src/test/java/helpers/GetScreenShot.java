package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class GetScreenShot {
    public static void capture(WebDriver driver, String screenshotName){
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            //create one file
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            //create name for file
            FileUtils.copyFile(file, new File("./screenshots/"+screenshotName+".png"));
        }catch(IOException e){
            //IO - Imput Out
            System.out.println(("File IO problem" + e.getMessage()));
        }
    }
}
