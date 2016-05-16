package gmail;


import gmail.gmailPages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static gmail.CaptureScreenshot.screenshot;

public class HighlightElement extends BasePage{
    public static Logger logger = LogManager.getRootLogger();

    public HighlightElement(WebDriver driver) {
        super(driver);
    }
    public static void highLightElement(WebDriver driver, WebElement element)
    {

        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        screenshot(driver);
        logger.info("element is highlighted");


        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

        logger.info("element is unhighlighted");
    }

    public static void highLightElementWihoutScreenshot (WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        logger.info("element is highlighted");


        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

        logger.info("element is unhighlighted");
    }

    }


