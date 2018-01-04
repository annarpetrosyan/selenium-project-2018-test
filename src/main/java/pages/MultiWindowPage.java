package pages;

import helper.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class WindowHandlerPage extends BasePage {

    /**
     * This is constructor
     *
     * @param webDriver
     */
    public WindowHandlerPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/windows");
    }
}
