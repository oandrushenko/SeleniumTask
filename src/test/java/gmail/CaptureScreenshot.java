package gmail;

import gmail.gmailPages.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


public class CaptureScreenshot extends BasePage {
   public static Logger logger = LogManager.getRootLogger();

    public CaptureScreenshot(WebDriver driver){
    super(driver);

}
    public static void screenshot(WebDriver driver)
    {

        try{
            //take screenshot and save it in a file
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path
            FileUtils.copyFile(screenshot,new File("target/screenshot/webPage_screenshot_"+GetTimeStampValue()+".jpeg"));
            logger.info("Screenshot is saved");
        }catch(Exception e){
            //if it fails to take screenshot then this block will execute
            logger.info("Failure to take screenshot "+e);
        }

    }
    public static String GetTimeStampValue()throws IOException{
        Calendar cal = Calendar.getInstance();
        Date time=cal.getTime();
        String timestamp=time.toString();
        System.out.println(timestamp);
        String systime=timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;
    }
}

