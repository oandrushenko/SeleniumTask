package gmail.gmailPages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private static final By composeNewMail=By.xpath("//div[text()='COMPOSE']");
    private static final By pressSpamButton= By.xpath("//a[contains(text(),'Spam')]");
    private static final By pressInboxFolder = By.xpath("//a[contains(text(),'Inbox')]");
    private static final By searchInBox= By.id("gbqfq");
    private static final String searchText=("in:spam seleniumtask4.1@gmail.com");
    private static final By checkBoxForMail = By.xpath("//table[contains(@class, 'F')]//tr[1]//td[2]//div[@role='checkbox']");

    public HomePage(WebDriver driver){
        super(driver);
    }

   public java.lang.String getMsg() throws Exception{
       return driver.findElement(By.id("h1")).getText();
   }

    public ComposeMailPage clickCompose() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(composeNewMail));
        driver.findElement(composeNewMail).click();
        return new ComposeMailPage(driver);
    }

    public HomePage clickSpam() {
        WebElement until = new WebDriverWait(driver, 6l).until(ExpectedConditions.visibilityOfElementLocated(pressInboxFolder));
        driver.findElement(pressInboxFolder).click();
        driver.findElement(searchInBox).sendKeys("seleniumtask4.1@gmail.com" + Keys.ENTER);
        boolean isPresent = driver.findElements(checkBoxForMail).size() > 0;
        WebElement until1 = new WebDriverWait(driver, 6l).until(ExpectedConditions.presenceOfElementLocated(checkBoxForMail));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(checkBoxForMail));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(pressSpamButton));

        return new HomePage(driver);
    }

    public HomePage checkSpam() {
        driver.findElement(searchInBox).sendKeys(searchText + Keys.ENTER);
        return new HomePage(driver);
    }
}


