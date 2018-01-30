package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class StatusCodesPage extends BasePage {
//    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(css = "#content div h3")
    private WebElement statusCodeHeaderSelector;

//    @FindBy(css = ".example")
//    private String statusCodeSelector;
    private String statusCodeSelector = ".example";

//    @FindBy(css = "#content div p")
//    private String statusCodeMessageInOpenedPage;
    private String statusCodeMessageInOpenedPage = "#content div p";

    //
    /**
     * This is constructor
     *
     *
     */
    public StatusCodesPage() {
        logger.info("Constructor");
        get(getUrl());
    }

    public String getUrl(){
        logger.info("Generate URL");
        return BASE_URL + "/status_codes";
    }

    @Override
    protected void load() {

    }
//
//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(statusCodeHeaderSelector)
//                .waitForElementIsClickable(statusCodeHeaderSelector);
//    }

    /**
     * This method get text of Header in Status Code
     * @return
     */
    public String getHeaderText() {
        logger.info("Get text of Header");
        return getText(statusCodeHeaderSelector);
    }

    /**
     *  Get Codes by cssSelector
     * @return
     */
    public WebElement getCodes(){
        logger.info("Get Code");
        return find(By.cssSelector(statusCodeSelector));
    }

    /**
     * Get Elements and set in List<OwnWebDriver>
     * @return
     */
    public List<WebElement> getElements(){
        logger.info("Add codes in array");
        return getCodes().findElements(By.tagName("a"));
    }

    /**
     * Check with condition the code == value and click on Code
     * @param value
     */
    public void clickOnStatusCode(String value){
        logger.info("Click on Code by value. Value = " + value);
        List<WebElement> elements = getElements();
        for(WebElement element:elements){
            if(element.getText().equals(value)){
                element.click();
            }
        }
    }

    /**
     *
     * @return
     */
    public String getMessageInOpenedPageOfStatus() {
        logger.info("Get message of Code");
        return getText(statusCodeMessageInOpenedPage);
    }
}
