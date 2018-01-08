package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class StatusCodesPage extends BasePage {

    private String statusCodeHeaderSelector = "#content div h3";
    private String statusCodeSelector = ".example";
    private String statusCodeMessageInOpenedPage = "#content div p";

    //
    /**
     * This is constructor
     *
     * @param webDriver
     */
    public StatusCodesPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/status_codes");
    }

    /**
     * This method get text of Header in Statis Code
     * @return
     */
    public String getHeaderText() {
        return getText(statusCodeHeaderSelector);
    }

    /**
     *  Get Codes by cssSelector
     * @return
     */
    public WebElement getCodes(){
        return find(statusCodeSelector);
    }

    /**
     * Get Elements and set in List<WebElement>
     * @return
     */
    public List<WebElement> getElements(){
        return getCodes().findElements(By.tagName("a"));
    }

    /**
     * Check with condition the code == value and click on Code
     * @param value
     */
    public void clickOnStatusCode(String value){
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
        return getText(statusCodeMessageInOpenedPage);
    }
}
