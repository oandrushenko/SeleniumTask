package gmail.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {



        private static final By UserLoginInput= By.id("Email");
        private static final By PasswordInput  = By.id("Passwd");
        private static final By SignInButton =  By.id("signIn");
        private static final By NextButton = By.id("next");
        private static final By IconBar=By.xpath("//div[@class='gb_nc']");
        private static final By GmailIcon=By.cssSelector("ul.gb_ja.gb_ca>li:nth-of-type(7)");
        private static final By SignInAsDifferentUser = By.id("account-chooser-link");
        private static final By AddNewAccountButton = By.id("account-chooser-add-account");



        public LoginPage(WebDriver driver) {
            super(driver);

        }
    public HomePage loginWith(String username, String password) {
        executeLogin(username, password);
        return new HomePage(driver);

    }

    public LoginPage signInAsDifferentUser(){
      driver.findElement(SignInAsDifferentUser).click();
        driver.findElement(AddNewAccountButton).click();
        return new LoginPage(driver);

    }
    public LoginPage chooseDifferentExistingUser(String email) {
        driver.findElement(By.xpath(String.format("//button[//span[text()='%s']]", email))).click();

        return this;
    }
    public HomePage enterPassword(String password) {
        driver.findElement(PasswordInput).sendKeys(password);
        driver.findElement(SignInButton).submit();
        driver.findElement(IconBar).click();
        new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOfElementLocated(GmailIcon)).click();

        return new HomePage(driver);
    }

        private void executeLogin(String username, String password){

            WebElement until = new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOfElementLocated(UserLoginInput));
            driver.findElement(UserLoginInput).sendKeys(username);
            driver.findElement(NextButton).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
            driver.findElement(PasswordInput).sendKeys(password);
            driver.findElement(SignInButton).submit();
            driver.findElement(IconBar).click();
            new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOfElementLocated(GmailIcon));
            driver.findElement(GmailIcon).click();
        }





            }

