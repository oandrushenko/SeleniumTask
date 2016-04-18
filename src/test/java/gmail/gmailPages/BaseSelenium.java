package gmail.gmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseSelenium {
    public static WebDriver driver;

    public static void init(){
        WebDriver driver = new FirefoxDriver();
    }

    public static void close(){
        driver.quit();
    }

}
