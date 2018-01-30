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
public class FramePage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(id = "mce_0_ifr")
    private WebElement frameId;

    @FindBy(tagName = "body")
    private WebElement textEditorTagName;

    //
    /**
     * This is constructor
     *
     */
    public FramePage() {
        logger.info("Constructor, get url");
        get(getUrl());
    }

    public String getUrl(){
        logger.info("Generate URL. Concat to BaseURL");
        return BASE_URL + "/tinymce";
    }

    @Override
    protected void load() {

    }
//
//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(textEditorTagName)
//                .waitForElementIsClickable(textEditorTagName);
//    }

    /**
     *
     */
    public void changeFrame(){
        logger.info("Change frame");
        driver.switchTo().frame(frameId);
    }

    public void fillTextInTextEditor(String text){
        logger.info("Clear text Editor content");
        textEditorTagName.clear();
        logger.info("Fill new text. Text = "  + text);
        textEditorTagName.sendKeys(text);
    }



}
