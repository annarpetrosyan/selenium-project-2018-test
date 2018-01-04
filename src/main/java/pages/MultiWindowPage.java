package pages;

import helper.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class MultiWindowPage extends BasePage {
    private String hrefcssSelector = ".example a";

    /**
     * This is constructor
     *
     * @param webDriver
     */
    public MultiWindowPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/windows");
    }

    /**
     * Click on Click here link
     */
    public void clickOnClickHereLink(){
        find(hrefcssSelector).click();
    }

    /**
     *  Take all windows ans set in array
     * @return
     */
    public Object[] getAllWindows(){
        return driver.getWindowHandles().toArray();
    }

    /**
     * Switch to window
     * @param index
     */
    public void switchToWindow(int index){
        driver.switchTo().window(getAllWindows()[index].toString());
    }

}
