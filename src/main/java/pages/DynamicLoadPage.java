package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/13/2018.
 */
public class DynamicLoadPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());
    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement finishSelector;

    @FindBy(id = "loading")
    private WebElement loadingSelector;

    /**
     * This is constructor
     *
     */
    public DynamicLoadPage() {
        logger.info("Get Url - constructor");
        get(getUrl());
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        waitForElement(startButton);
    }


    public String getUrl(){
        logger.info("Generate URL. Contact to BaseURL ");
        return BASE_URL + "/dynamic_loading/1";
    }

    public void clickOnStart(){
        logger.info("Click on Start button");
        click(startButton);
    }

    public boolean isLoadingDisplayed(){
        logger.info("Is loading display?");
        return isDisplayed(loadingSelector, 10);
    }

    public boolean isLoadingNotDisplayed(){
        logger.info("Is not loading display?");
        return  isNotDisplayed(loadingSelector, 10);
    }



    public boolean isFinishDisplayed(){
        logger.info("Is finish display?");
        return isDisplayed(finishSelector, 10);
    }



    public WebElement getFinish(){
        logger.info("Return finish webElement?");
        return finishSelector;
    }

}
