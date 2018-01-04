package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class HoverPage extends BasePage {

    private String avatarSelector = "figure";
    private String avatarInfo = "figcaption";




    /**
     * This is constructor
     *
     * @param webDriver
     */
    public HoverPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/hovers");
    }

    /**
     * Hover to element
     * @param webElement
     */
    public void hoverToElement(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    /**
     *
     * @param locator
     */
    public void hoverToElement(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(find(locator)).build().perform();
    }

    /**
     * check header is displayed
     * @return
     */
    public boolean isHeaderDisplayed(){
        return isDisplayed(avatarInfo);
    }

    /**
     *  check header is not displayed
     * @return
     */
    public boolean isHeaderNotDisplayed(){
        return isNotDisplayed(find(By.className(avatarInfo)), 5);
//        return isNotDisplayed(, 10);
    }


    /**
     * Return content of Avatar
     * @return
     */
//    public WebElement getHeader(){
//        hoverToAvatar();
//        return find(avatarInfo);
//    }
//    public List<WebElement> getHovers(){
//        return findElements(By.cssSelector(avatarInfo));
//    }
//
//    public WebElement getHoverByIndex(){
//        List<WebElement> values = getHovers();
//        return values;
//    }
//
//    public void hoverToAvatarByIndex(int index){
//        List<WebElement> values = getHovers();
//        hoverToElement(values(index));
//    }
//
//
//    /**
//     *
//     */
//    public void hoverToAvatar(int index){
//        hoverToElement(getHoverByIndex(index));
//    }

}
