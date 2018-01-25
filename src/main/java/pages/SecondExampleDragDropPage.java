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
public class SecondExampleDragDropPage extends BasePage {

    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(css = "div#draggable")
    private WebElement elementASelector;

    @FindBy(css = "div#droppable")
    private WebElement elementBSelector;

    @FindBy(css = "body")
    private WebElement invalidDroppableSelector;

    public SecondExampleDragDropPage() {
        logger.info("Constructor");
        get(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(elementASelector)
                .waitForElementIsClickable(elementASelector);
    }

    public String getUrl() {
        logger.info("Get URL");
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    public void dragAndDropSecondExample(){
        logger.info("Drag and drop");
            dragAndDrop(elementASelector, elementBSelector);
    }

    public String getDroppableText(){
        logger.info("Get text after drag and drop");
        return getText(elementBSelector);
    }

}
