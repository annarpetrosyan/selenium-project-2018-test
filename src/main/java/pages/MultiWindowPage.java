package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class MultiWindowPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(css = ".example a")
    private WebElement hrefcssSelector;

    /**
     * This is constructor
     *
     *
     */
    public MultiWindowPage( ) {
        logger.info("Constructor. Get Url");
        get(getUrl());
    }
    public String getUrl(){
        logger.info("Generate URL. Contact to BaseURl");
        return BASE_URL + "/windows";
    }
    /**
     * Click on Click here link
     */
    public void clickOnClickHereLink(){
        logger.info("Click on Here Link");
        hrefcssSelector.click();
    }

    /**
     *  Take all windows ans set in array
     * @return
     */
    public Object[] getAllWindows(){
        logger.info("Get Windows and refatoring to Array");
        return driver.getWindowHandles().toArray();
    }

    /**
     * Switch to window
     * @param index
     */
    public void switchToWindow(int index){
        logger.info("Switch to window by index. Index = " + index);
        driver.switchTo().window(getAllWindows()[index].toString());
    }



}
