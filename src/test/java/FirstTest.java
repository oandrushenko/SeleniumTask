import gmail.CaptureScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class FirstTest extends BaseTest {

    @Test
    public void testHomePage() throws Exception {


        sentMail();
        userMarkAsSpam();
        sentMailSecond();
        checkThatMailInSpam();
    }

    private void sentMail() {
                logger.info("Sending first mail");
                CaptureScreenshot captureScreenshot = new CaptureScreenshot(driver);
                captureScreenshot.screenshot(driver);
                getLoginPage()
                .loginWith("seleniumtask4.1@gmail.com", "123qweasd!@#")
                .clickCompose()
                .composeNewMail("seleniumtask4.2@gmail.com", "new mail", "Hello")
                .executeLogout();

    }

    private void userMarkAsSpam() {
        logger.info("Mark first mail as spam");
               getLoginPage()
                .signInAsDifferentUser()
                .loginWith("seleniumtask4.2@gmail.com", "123qweasd!@#")
                .clickSpam()
                .executeLogout();
    }

    private void sentMailSecond() {
        logger.info("Sending second mail");
                getLoginPage()
                .chooseDifferentExistingUser("seleniumtask4.2@gmail.com")
                .enterPassword("123qweasd!@#")
                .clickCompose()
                .composeNewMail("seleniumtask4.2@gmail.com", "new mail for spam", "Hello there ")
                .executeLogout();

    }

    private void checkThatMailInSpam() {
        logger.info("Check that mail is in spam");
              getLoginPage()
                .chooseDifferentExistingUser("seleniumtask4.2@gmail.com")
                .enterPassword("123qweasd!@#")
                .checkSpam()
                .executeLogout();
    }


}


