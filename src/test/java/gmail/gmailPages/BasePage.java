package gmail.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    private static final By FaceIcon = By.xpath("//a[contains(@title,'Google Account:')]");
    private static final By PressLogoutButton =By.linkText("Sign out");

    public BasePage(WebDriver driver){
      this.driver=driver;
    }

    public LoginPage executeLogout() {
        driver.findElement(FaceIcon).click();
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
