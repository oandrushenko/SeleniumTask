package gmail.gmailPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComposeMailPage extends BasePage{

    private static final By composeNewMail= By.xpath("//div[text()='COMPOSE']");
    private static final By sendTo=By.xpath("//textarea[@name='to']");
    private static final By subjectIs=By.xpath("//input[@name='subjectbox']") ;
    private static final By messageBody=By.xpath("//div[@role='textbox']");
    private static final By sendButton=By.xpath("//div[text()='Send']");

    public ComposeMailPage(WebDriver driver) {
        super(driver);

    }


    public HomePage composeNewMail(String recipient, String subject, String message) {
        new WebDriverWait(driver, 3l).until(ExpectedConditions.presenceOfElementLocated(sendTo)).sendKeys(recipient);
        driver.findElement(subjectIs).sendKeys(subject);
        driver.findElement(messageBody).sendKeys(message);
        driver.findElement(sendButton).click();

        return new HomePage(driver);
    }



}
