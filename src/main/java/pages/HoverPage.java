package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class HoverPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());
    // //I have question related with this class --todo

//    @FindBy(css = ".figure")
    private String avatarSelector = ".figure";

    @FindBy(className = "figcaption")
    private WebElement avatarInfo;
    /**
     * This is constructor
     */
    public HoverPage( ) {
        logger.info("Constructor. Get Url");
        get(getUrl());
    }
    public String getUrl(){
        logger.info("Generate URL. Contact to BASE URL");
        return BASE_URL + "/hovers";
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        waitForElement(avatarInfo);
    }

    /**
     * check header is displayed
     * @return
     */
    public boolean isHeaderDisplayed(){
        logger.info("Is header display?");
        return isDisplayed(avatarInfo, 5);
    }

    /**
     *  check header is not displayed
     * @return
     */
    public boolean isHeaderNotDisplayed(){
        logger.info("Is not header display?");
        return isNotDisplayed(avatarInfo, 5);
    }

    /**
     *
     * @param element
     */
    public void hoverElement(WebElement element){
        logger.info("Hover on element. Element = " + element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /**
     *
     * @return
     */
    public List<WebElement> getAvatars(){
        logger.info("Find elements of avatar. getAvatars");
        return findElements(By.cssSelector(avatarSelector));
     }


    public void hoverAvatar(int index) {
        logger.info("Hover on avatar by index. Index = ");
        hoverElement(getAvatars().get(index));

    }


//
    /**
     * Return content of Avatar
     * @return
     */
    public WebElement getHeader(int index){
        hoverAvatar(index);
        logger.info("get Header of avatar by index. Index = " + index);
        return avatarInfo;
    }


}
