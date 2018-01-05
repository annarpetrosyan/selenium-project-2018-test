package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class HoverPage extends BasePage {

    private String avatarSelector = ".figure";
    private String avatarInfo = ".figcaption";



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
     * check header is displayed
     * @return
     */
    public boolean isHeaderDisplayed(){
        return isDisplayed(find(By.className(avatarInfo)), 5);

    }

    /**
     *  check header is not displayed
     * @return
     */
    public boolean isHeaderNotDisplayed(){
        return isNotDisplayed(find(By.className(avatarInfo)), 5);
    }

    /**
     *
     * @param element
     */
    public void hoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

//    public void hoverAvatar() {
//        hoverElement(find(By.className("figure")));
//
//    }

    /**
     *
     * @return
     */
    public List<WebElement> getAvatars(){
        return findElems(By.cssSelector(avatarSelector));
     }


    public void hoverAvatar(int index) {
        hoverElement(getAvatars().get(index));

    }


//    /**
//     * Hover to element
//     * @param webElement
//     */
//    public void hoverToElement(WebElement webElement){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(webElement).build().perform();
//    }

//
//
    /**
     * Return content of Avatar
     * @return
     */
    public WebElement getHeader(int index){
        hoverAvatar(index);
        return find(avatarInfo);
    }
//
//    public WebElement getHovers(){
//        return find(By.cssSelector("figure"));
//    }
//
//    /**
//     * Get all options of drop down
//     * @return
//     */

//
//
//
//    public void hoverToAvatar(int index){
//        List<WebElement> elements = getElements();
//               hoverToElement(elements.get(index));
//    }
//

}
