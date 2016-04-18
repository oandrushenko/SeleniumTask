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
        getLoginPage()
                .loginWith("seleniumtask4.1@gmail.com", "123qweasd!@#")
                .clickCompose()
                .composeNewMail("seleniumtask4.2@gmail.com", "new mail", "Hello")
                .executeLogout();

    }

    private void userMarkAsSpam() {
        getLoginPage()
                .signInAsDifferentUser()
                .loginWith("seleniumtask4.2@gmail.com", "123qweasd!@#")
                .clickSpam()
                .executeLogout();
    }

    private void sentMailSecond() {
        getLoginPage()
                .chooseDifferentExistingUser("seleniumtask4.2@gmail.com")
                .enterPassword("123qweasd!@#")
                .clickCompose()
                .composeNewMail("seleniumtask4.2@gmail.com", "new mail for spam", "Hello there ")
                .executeLogout();

    }

    private void checkThatMailInSpam() {
        getLoginPage()
                .chooseDifferentExistingUser("seleniumtask4.2@gmail.com")
                .enterPassword("123qweasd!@#")
                .checkSpam()
                .executeLogout();
    }


}


