package gmail.cucumberSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmail.gmailPages.BaseSelenium;
import gmail.gmailPages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseStepDef extends BaseSelenium {

    @Given("^User login name \"seleniumtask4.1@gmail.com\"")

    public void isEnterloginName(String username) throws Throwable {

        driver.get("https://accounts.google.com/");
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("next")).click();


    }

    @When("^User enter password")
    public void isEnterPassword(String password) throws Throwable {
        driver.findElement(By.id("Passwd")).sendKeys(password);
        driver.findElement(By.id("signIn")).submit();
        driver.findElement(By.xpath("//div[@class='gb_nc']")).click();
        new WebDriverWait(driver, 3l).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.gb_ja.gb_ca>li:nth-of-type(7)")));
        driver.findElement(By.cssSelector("ul.gb_ja.gb_ca>li:nth-of-type(7)")).click();

    }

    @Then("^User is able to create message")
    public void userIsAbleToCreateTheMessage() throws Throwable {
        WebElement composeMail= driver.findElement(By.xpath("//div[text()='COMPOSE']"));
        Assert.assertEquals(true, composeMail.isDisplayed());

    }
}
