import gmail.gmailPages.Decorator;
import gmail.gmailPages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    private final String url = "https://accounts.google.com/";
    public Logger logger = LogManager.getRootLogger();

    public LoginPage getLoginPage() {
        driver.get(url);
        return new LoginPage(driver);
    }
@Before
    public void setup() {
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
            UnexpectedAlertBehaviour.DISMISS);
    driver = new FirefoxDriver();
    /*driver = new Decorator(driver);*/
    driver.manage().timeouts().implicitlyWait(6l, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10l, TimeUnit.SECONDS);

    driver.get(url);
}

    @After
    public void tearDown()
    {logger.info("Test is completed");
        driver.quit();
    }
}
