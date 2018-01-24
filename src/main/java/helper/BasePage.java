package helper;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> implements WebDriver {
    protected WebDriver driver;
    private JavascriptExecutor js = (JavascriptExecutor) driver;;
    Logger logger = Logger.getLogger(Log.class.getName());
    private WebDriverWait wait;



    public WebElement waitForElement(WebElement webElement){
      WebDriverWait wait=  new WebDriverWait(driver, 10);
          return wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
    driver.getCurrentUrl().contains(getUrl());
    }

    public static final String BASE_URL =
            System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public abstract String getUrl();

    /**
     * This is constructor
     *
     */
    public BasePage(){
            driver = getDriver();
            PageFactory.initElements(driver,this);
     }

    /**
     * This method clean cookies, local storage and maximize the window
     * @param BaseUrl
     */
    public void get(String BaseUrl) {
    logger.info("Get Url");
        driver.get(BaseUrl);
    logger.info("Cleaning Cookies");
        driver.manage().deleteAllCookies();
    logger.info("Maximize window");
        driver.manage().window().maximize();
    logger.info("Cleaning local Storage");
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
//        js.executeScript("window.localStorage.clear();");
        this.get();

    }


    /** -------------------------------
     * Get ul Element for List
     * @param indexNumber
     *  --Todo uzum em mi hat element tam, vor yndhanracvac lini
     * @return // add web element
     * and check element.findElements ()
     * WebElement element
     */
    public WebElement getLiForUlByIndex( int indexNumber){
       WebElement uLElement = find(By.tagName("ul"));
        List<WebElement> liElement = uLElement.findElements(By.tagName("li"));
         int listSize = liElement.size();
        for(int i=0; i < listSize; i++){
            if(i == indexNumber-1){
                return liElement.get(i);
            }
        }
        return null;
    }

    /**
     * Get column webElement by provided row and cell index
     * @param tableElement 1
     *      WebElement of table
     * @param rowNumber
     *        row Number
     * @param cellNumber
     *         cell Number
     * @return
     *      Web element of column This is changes for branch
     */
    public WebElement getTableColumnElementByRowNumberCellNumber(WebElement tableElement, int rowNumber, int cellNumber){
        WebElement table = tableElement.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(rowNumber-1).findElements(By.tagName("td"));
        return cells.get(cellNumber-1);
    }

    /**
     * This method click on table header by provided rowNumber and cellNumber (th)
     * @param tableElement
     *      WebElement of table
     * @param rowThNumber
     *        row th Number
     * @param cellThNumber
     *         cell th Number
     */
    public void clickOnTableHeaderByWebElementRowNumberColumnNumber(WebElement tableElement, int rowThNumber, int cellThNumber){
        WebElement table = tableElement.findElement(By.tagName("thead"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(rowThNumber-1).findElements(By.tagName("th"));
        cells.get(cellThNumber-1).click();
    }

    /**
     * Get web Element of checkbox
     * @param webElement
     *      Web element of checkbox form (e.g. form, div)
     * @param indexNumber
     *      number of index
     * @return
     *      web element for provided index
     */
    public WebElement getCheckBoxElementByIndex(WebElement webElement, int indexNumber){
        List<WebElement> checkboxes = webElement.findElements(By.tagName("input"));
        return checkboxes.get(indexNumber-1);
    }

    public boolean getAttributeOfCheckbox(WebElement webElement, int indexNumber){
        WebElement element = getCheckBoxElementByIndex(webElement, indexNumber);
        return Boolean.parseBoolean(element.getAttribute("checked"));
    }

    public void uncheckCheckboxElementByIndex(WebElement webElement, int indexNumber){
        if(getAttributeOfCheckbox(webElement, indexNumber)){
            click(getCheckBoxElementByIndex(webElement,indexNumber));
        }
    }


    public void checkCheckboxElementByIndex(WebElement webElement, int indexNumber){
        if(!getAttributeOfCheckbox(webElement, indexNumber)){
            click(getCheckBoxElementByIndex(webElement,indexNumber));
        }
    }

    //  ---------------------------------------
    /**
     * Close driver
     */
    public void close() {
    logger.info("Close driver");
    }

    /**
     * Quit driver
     */
    public void quit() {
        logger.info("Quit driver");
    }

    /**
     * This is General FIND method which work with driver
     * @param locator
     */
    public WebElement find(By locator){
    logger.info("Find Element by locator (driver)");
        return driver.findElement(locator);
    }

    /**
     * This is General FIND method which work with driver
     * @param locator
     */
    public List<WebElement> findElems(By locator){
        logger.info("Find Element by locator (driver)");
        return driver.findElements(locator);
    }


    /**
     * This is overloaded FIND method which work with general find method
     * @param cssSelector
     * @return WebElement
     */
    public WebElement find(String cssSelector){
    logger.info("Find Element by cssSelector");
        return find(By.cssSelector(cssSelector));
    }

    /**
     * This is General FILL method which work with driver
     * @param webElement
     * @param value
     */
    public void fill(WebElement webElement, String value){
    logger.info("Clear Content");
        webElement.clear();
    logger.info("Fill method - driver - sendKeys");
       webElement.sendKeys(value);
    }

    /**
     * This is overloaded FILL method which work with existing fill and find methods
     * @param locator
     * @param value
     */
    public void fill(By locator, String value){
    logger.info("Overloaded fill method (locator)");
       fill(find(locator), value);
    }

    public void fill(String cssSelector, String value){
    logger.info("Overloaded fill method (cssSelector)");
        fill(find(cssSelector), value);
    }

    /**
     * This is General CLICK method which works with driver
     * @param webElement
     */
    public void click(WebElement webElement){
    logger.info("Click method(driver)");
        webElement.click();
    }

    /**
     * This is overloaded click method - By locator
     * @param locator
     */
    public void click(By locator){
    logger.info("Overloaded click method(by locator)");
        click(find(locator));
    }

    /**
     * This is overloaded click method - cssSelector
     * @param cssSelector
     */
    public void click(String cssSelector){
    logger.info("Overloaded click method(cssSelector)");
        click(find(cssSelector));
    }

    /**
     * This is General isDisplayed method which work with driver's method
     * @param webElement
     * @return true or false
     */
    public boolean isDisplayed(WebElement webElement){
    logger.info("isDisplayed method (driver)");
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
    logger.info("Overloaded isDisplayed method (locator)");
        return isDisplayed(find(locator));
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param cssSelector
     * @return
     */
    public boolean isDisplayed(String cssSelector){
        logger.info("Overloaded isDisplayed method (cssSelector)");
        return isDisplayed(find(cssSelector));
    }


    /**
     * This is General isNotDisplayed method which work with driver's method
     * @param webElement
     * @param timeout
     * @return
     */
    public boolean isNotDisplayed(WebElement webElement, Integer timeout){
//        logger.info("isNotDisplayed method (driver)");
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        }catch (TimeoutException message){
            return false;
        }
        return true;
    }

    public boolean isDisplayed(WebElement webElement, Integer timeout){
//        logger.info("isNotDisplayed method (driver)");
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
        logger.info("Overloaded isNotDisplayed method (locator)");
        return  isNotDisplayed(find(locator), timeout);
    }

    /**
     * This is overloaded isDisplayed method which work with existing methods
     * @param cssSelector
     * @param timeout
     * @return
     */
    public boolean isNotDisplayed(String cssSelector, Integer timeout){
        logger.info("Overloaded isNotDisplayed method (cssSelector)");
        return  isNotDisplayed(find(cssSelector), timeout);
    }

    /**
     * This is General getText method which use driver's method
     * @param webElement
     * @return
     */
    public String getText(WebElement webElement){
        logger.info("General get method");
        return  webElement.getText();
    }

    /**
     * This is overloaded getText method which work with existing methods
     * @param locator
     * @return
     */
    public String getText(By locator){
        logger.info("Overloaded get method (locator0");
        return getText(find(locator));
    }

    /**
     *  This is overloaded getText method which work with existing methods
     * @param cssSelector
     * @return
     */
    public String getText(String cssSelector){
        logger.info("Overloaded get method (locator0");
        return getText(find(cssSelector));
    }


// ----- Implementation - IN PROGRESS --todo
    /**
     *
     * @return current url
     */
    public String getCurrentUrl() {
    logger.info("Get current URl");
        return driver.getCurrentUrl();
    }

    public void dragAndDrop(WebElement webElement1, WebElement webElement2){
        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(webElement1).moveToElement(webElement2).release(webElement2).build();
        dragAndDrop.perform();
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
