package gmail.gmailPages;


import org.openqa.selenium.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
    import java.util.Set;


    public class Decorator implements WebDriver,JavascriptExecutor  {

        protected WebDriver driver;

        public Decorator(WebDriver driver) {
            this.driver = driver;
        }


        public void get(String url) {
            driver.get(url);
        }

        public String getCurrentUrl() {
            return driver.getCurrentUrl();
        }

        public String getTitle() {
            return driver.getTitle();
        }

        public List<WebElement> findElements(By by) {
            return driver.findElements(by);
        }

        public WebElement findElement(By by) {
            System.out.println("Looking for element with locator: " + by.toString());
            return driver.findElement(by);
        }

        public String getPageSource() {
            return driver.getPageSource();
        }

        public void close() {
            driver.close();
        }

        public void quit() {
            driver.quit();
        }

        public Set<String> getWindowHandles() {
            return driver.getWindowHandles();
        }

        public String getWindowHandle() {
            return driver.getWindowHandle();
        }

        public TargetLocator switchTo() {
            return driver.switchTo();
        }

        public Navigation navigate() {
            return driver.navigate();
        }

        public Options manage() {
            return driver.manage();
        }

        public Object executeScript(String s, Object... objects) {
            return null;
        }

        public Object executeAsyncScript(String s, Object... objects) {
            return null;
        }
    }

