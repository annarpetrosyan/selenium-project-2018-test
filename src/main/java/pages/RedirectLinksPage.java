package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

import static setup.DriverSetup.initDriver;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class RedirectLinksPage  extends BasePage{

    @FindBy(id = "redirect")
    private WebElement hereLinkSelector;

    public RedirectLinksPage(){
        logger.info("Get URL for Redirect Links page");
        get(getUrl());
    }
    @Override
    public String getUrl() {
        return BASE_URL + "/redirector";
    }


    public void clickOnHere(){
        logger.info("Click On Here");
        click(hereLinkSelector);
    }

    public void switchToWindowByIndex(int indexNumber){
        Set<String> allHandles = initDriver().getWindowHandles();
        int windowsCount = allHandles.size()-1;
        for (int i=0; i < windowsCount; i++){
            if(i == indexNumber){
                String handle =  allHandles.toArray()[i].toString();
                initDriver().switchTo().window(handle);
            }
        }
    }


    private String statusCodeSelector = ".example";
    private String statusCodeMessageInOpenedPage = "#content div p";

    /**
     *
     * @return
     */
    public String getMessageInOpenedPageOfStatus() {
        logger.info("Get message of Code");
        return getText(statusCodeMessageInOpenedPage);
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

}
