package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DragDropPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(css = "div #column-a")
    private WebElement webElementASelector;

    @FindBy(css = "div #column-b")
    private WebElement webElementBSelector;

    public DragDropPage() {
        logger.info("Constructor of DragANDDrop class");
        get(getUrl());
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(webElementBSelector)
                .waitForElementIsClickable(webElementBSelector);
        CommonWaits.getWait().
                waitForElementIsVisible(webElementASelector)
                .waitForElementIsClickable(webElementASelector);
    }

    public String getUrl() {
        logger.info("Get Url");
        return BASE_URL + "/drag_and_drop";
    }


    public void dragAndDrop(){
          logger.info("Drag A to B");
           dragAndDrop(webElementASelector, webElementBSelector);

    }

}
