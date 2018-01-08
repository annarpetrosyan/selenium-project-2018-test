package helper;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class BasePage implements WebDriver {
    protected WebDriver driver;
    private JavascriptExecutor js = (JavascriptExecutor) driver;;
    private Logger log = Logger.getLogger(Log.class.getName());;
    private WebDriverWait wait;


    /**
     * This is constructor
     * @param webDriver
     */
    public BasePage(WebDriver webDriver){
        this.driver=webDriver;
     }

    /**
     * This method clean cookies, local storage and maximize the window
     * @param BaseUrl
     */
    public void get(String BaseUrl) {
    log.info("Get Url");
        driver.get(BaseUrl);
    log.info("Cleaning Cookies");
        driver.manage().deleteAllCookies();
    log.info("Maximize window");
        driver.manage().window().maximize();
    log.info("Cleaning local Storage");
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
//        js.executeScript("window.localStorage.clear();");


    }

    /**
     * Close driver
     */
    public void close() {
    log.info("Close driver");
    }

    /**
     * Quit driver
     */
    public void quit() {
        log.info("Quit driver");
    }

    /**
     * This is General FIND method which work with driver
     * @param locator
     */
    public WebElement find(By locator){
    log.info("Find Element by locator (driver)");
        return driver.findElement(locator);
    }

    /**
     * This is General FIND method which work with driver
     * @param locator
     */
    public List<WebElement> findElems(By locator){
        log.info("Find Element by locator (driver)");
        return driver.findElements(locator);
    }

    /**
     * This is overloaded FIND method which work with general find method
     * @param cssSelector
     * @return WebElement
     */
    public WebElement find(String cssSelector){
    log.info("Find Element by cssSelector");
        return find(By.cssSelector(cssSelector));
    }

    /**
     * This is General FILL method which work with driver
     * @param webElement
     * @param value
     */
    public void fill(WebElement webElement, String value){
    log.info("Clear Content");
        webElement.clear();
    log.info("Fill method - driver - sendKeys");
       webElement.sendKeys(value);
    }

    /**
     * This is overloaded FILL method which work with existing fill and find methods
     * @param locator
     * @param value
     */
    public void fill(By locator, String value){
    log.info("Overloaded fill method (locator)");
       fill(find(locator), value);
    }

    public void fill(String cssSelector, String value){
    log.info("Overloaded fill method (cssSelector)");
        fill(find(cssSelector), value);
    }

    /**
     * This is General CLICK method which works with driver
     * @param webElement
     */
    public void click(WebElement webElement){
    log.info("Click method(driver)");
        webElement.click();
    }

    /**
     * This is overloaded click method - By locator
     * @param locator
     */
    public void click(By locator){
    log.info("Overloaded click method(by locator)");
        click(find(locator));
    }

    /**
     * This is overloaded click method - cssSelector
     * @param cssSelector
     */
    public void click(String cssSelector){
    log.info("Overloaded click method(cssSelector)");
        click(find(cssSelector));
    }

    /**
     * This is General isDisplayed method which work with driver's method
     * @param webElement
     * @return true or false
     */
    public boolean isDisplayed(WebElement webElement){
    log.info("isDisplayed method (driver)");
       try {
           return webElement.isDisplayed();
       }catch (NoSuchElementException message){
           return false;
       }
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param locator
     * @return
     */
    public boolean isDisplayed(By locator){
    log.info("Overloaded isDisplayed method (locator)");
        return isDisplayed(find(locator));
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param cssSelector
     * @return
     */
    public boolean isDisplayed(String cssSelector){
        log.info("Overloaded isDisplayed method (cssSelector)");
        return isDisplayed(find(cssSelector));
    }


    /**
     * This is General isNotDisplayed method which work with driver's method
     * @param webElement
     * @param timeout
     * @return
     */
    public boolean isNotDisplayed(WebElement webElement, Integer timeout){
//        log.info("isNotDisplayed method (driver)");
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        }catch (TimeoutException message){
            return false;
        }
        return true;
    }

    public boolean isDisplayed(WebElement webElement, Integer timeout){
//        log.info("isNotDisplayed method (driver)");
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        }catch (TimeoutException message){
            return false;
        }
        return true;
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param locator
     * @param timeout
     * @return
     */
    public boolean isNotDisplayed(By locator, Integer timeout){
        log.info("Overloaded isNotDisplayed method (locator)");
        return  isNotDisplayed(find(locator), timeout);
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param cssSelector
     * @param timeout
     * @return
     */
    public boolean isNotDisplayed(String cssSelector, Integer timeout){
        log.info("Overloaded isNotDisplayed method (cssSelector)");
        return  isNotDisplayed(find(cssSelector), timeout);
    }

    /**
     * This is General getText method which use driver's method
     * @param webElement
     * @return
     */
    public String getText(WebElement webElement){
        log.info("General get method");
        return  webElement.getText();
    }

    /**
     * This is overloaded getText method which work with existing methods
     * @param locator
     * @return
     */
    public String getText(By locator){
        log.info("Overloaded get method (locator0");
        return getText(find(locator));
    }

    /**
     *  This is overloaded getText method which work with existing methods
     * @param cssSelector
     * @return
     */
    public String getText(String cssSelector){
        log.info("Overloaded get method (locator0");
        return getText(find(cssSelector));
    }


// ----- Implementation - IN PROGRESS --todo
    /**
     *
     * @return current url
     */
    public String getCurrentUrl() {
    log.info("Get current URl");
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public String getPageSource() {
        return null;
    }


    public Set<String> getWindowHandles() {
        return null;
    }

    public String getWindowHandle() {
        return null;
    }

    public TargetLocator switchTo() {
        return null;
    }

    public Navigation navigate() {
        return null;
    }

    public Options manage() {
        return null;
    }


}
