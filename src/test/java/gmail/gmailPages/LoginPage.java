package gmail.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginPage extends BasePage {

    @FindBy(id="Email")
    private WebElement UserLoginInput;

    @FindBy(id="Passwd")
    private WebElement PasswordInput;

    @FindBy(id="signIn")
    private WebElement SignInButton;

    @FindBy(id="next")
    private WebElement NextButton;

    @FindBy(xpath="//div[@class='gb_oc']")
    private WebElement IconBar;

    @FindBy(css ="ul.gb_ja.gb_ca>li:nth-of-type(7)" )
    private WebElement GmailIcon;

    @FindBy(id="account-chooser-link")
    private WebElement SignInAsDifferentUser;

    @FindBy(id="account-chooser-add-account")
    private WebElement AddNewAccountButton;


    public LoginPage(WebDriver driver) {
    super(driver);
            PageFactory.initElements(driver, this);

        }
    public HomePage loginWith(String username, String password) {
        executeLogin(username, password);
        return new HomePage(driver);

    }

    public LoginPage signInAsDifferentUser(){

        SignInAsDifferentUser.click();
        AddNewAccountButton.click();

        return new LoginPage(driver);

    }
    public LoginPage chooseDifferentExistingUser(String email) {
        driver.findElement(By.xpath(String.format("//button[//span[text()='%s']]", email))).click();

        return this;
    }
    public HomePage enterPassword(String password) {
        PasswordInput.sendKeys(password);
        SignInButton.submit();
        IconBar.click();
        new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOf(GmailIcon)).click();

        return new HomePage(driver);
    }

        private void executeLogin(String username, String password){

            WebElement until = new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOf(UserLoginInput));
            UserLoginInput.sendKeys(username);
            NextButton.click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(PasswordInput));
            PasswordInput.sendKeys(password);
            SignInButton.submit();
            IconBar.click();
            new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOf(GmailIcon));
            GmailIcon.click();

        }





            }

