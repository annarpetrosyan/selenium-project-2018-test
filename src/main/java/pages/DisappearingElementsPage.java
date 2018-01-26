package pages;

import helper.BasePage;
import helper.CommonVisibilityTypes;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DisappearingElementsPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(tagName = "ul")
    private WebElement menuListSelector;


    public DisappearingElementsPage() {
        logger.info("Get Url");
        get(getUrl());
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(menuListSelector)
                .waitForElementIsClickable(menuListSelector);
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/disappearing_elements";
    }

    /**
     * Get list li webElement
     * @param indexNumber
     * @return
     */
    public WebElement getMenuWebElementByIndex(int indexNumber){
        logger.info("Get li element by index");
        return getLiForUlByIndex(indexNumber);
    }

    /**
     * Get visibility of latest Element = Gallery
     * @return
     *  true or false
     */
    public boolean isDisplayedLatestContentOfMenuGallery(){
        try {
            CommonVisibilityTypes.getWait().isVisible(getLiForUlByIndex(5));

        }catch (NullPointerException e){
            return false;
        }
        return true;

    }

    public String getTextOfLatestElementIfExist(){
        try {
            CommonVisibilityTypes.getWait().isVisible(getLiForUlByIndex(5));
            return getLiForUlByIndex(5).getText();
          }catch (NullPointerException e){
            return  "Gallery is not displayed. Please, reload page and try again";
        }
    }


    public void clickOnMenuByIndexNumber(int indexNumber){
        click(getLiForUlByIndex(indexNumber));
    }
}
