package gmail.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;

    @FindBy(xpath="//a[contains(@title,'Google Account:')]")
    private WebElement FaceIcon;

    private static final By PressLogoutButton =By.linkText("Sign out");

    public BasePage(WebDriver driver){
      this.driver=driver;
    }

    public LoginPage executeLogout() {
        FaceIcon.click();
        new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOfElementLocated(PressLogoutButton)).click();
        waitFor(2000l);

        return new LoginPage(driver);
    }

    public void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
