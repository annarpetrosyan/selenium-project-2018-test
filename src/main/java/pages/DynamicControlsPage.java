package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DynamicControlsPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(id = "checkbox")
    private WebElement checkBoxSelector;

    @FindBy(id = "btn")
    private WebElement removeAddButtonSelector;


    @FindBy(id = "loading")
    private WebElement loadingSelector;


    @FindBy(id = "message")
    private WebElement resultMessageSelector;


    /**
     * Constructor
     */
    public DynamicControlsPage(){
        logger.info("Get URL for Dynamic Controls");
        get(getUrl());
    }

    @Override
    public String getUrl() {
        logger.info("Generate URL. Contact to Base_URL");
        return BASE_URL + "/dynamic_controls";
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElement(checkBoxSelector);
    }

    /**
     * This method check on A checkbox
     */
    public void checkTheCheckbox(){
        logger.info("Check A checkbox");
        checkCheckboxElementByIndex(checkBoxSelector, 1);
    }

    /**
     * This method click on button (Add || Remove)
     */
    public void clickOnAddRemoveButton(){
        logger.info("Click on button button");
        click(removeAddButtonSelector);
    }

    /**
     * This method return boolean value for progress bar visible state
     * @return
     *      true || false
     */
    public boolean isLoadingDisplayed(){
        logger.info("Is loading display?");
        return isDisplayed(loadingSelector);
    }

    /**
     * This method return boolean value for progress bar non visible state
     * @return
     *      true || false
     */
    public boolean isNotLoadingDisplayed(){
        logger.info("Is loading display?");
        return isNotDisplayed(loadingSelector, 10);
    }


    public String getResultAfterLoading(){
        return getText(resultMessageSelector);
    }


}
