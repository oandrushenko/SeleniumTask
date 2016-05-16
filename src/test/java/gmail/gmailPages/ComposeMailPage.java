package gmail.gmailPages;

import gmail.CaptureScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static gmail.CaptureScreenshot.screenshot;
import static gmail.HighlightElement.highLightElement;


public class ComposeMailPage extends BasePage{



    @FindBy(xpath="//input[@name='subjectbox']")
    private WebElement subjectIs;

    @FindBy(xpath="//div[text()='Send']")
    private WebElement sendButton;

    private static final By sendTo=By.xpath("//textarea[@name='to']");

    @FindBy(xpath="//div[@role='textbox']")
    private WebElement messageBody;


    public ComposeMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public HomePage composeNewMail(String recipient, String subject, String message) {
        new WebDriverWait(driver, 3l).until(ExpectedConditions.presenceOfElementLocated(sendTo)).sendKeys(recipient);

       subjectIs.sendKeys(subject);
        highLightElement(driver,messageBody);
        messageBody.sendKeys(message);

        sendButton.click();

        return new HomePage(driver);
    }



}
