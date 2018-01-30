package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class BasicAuthPage extends BasePage {
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    final String URL = "@the-internet.herokuapp.com/basic_auth";


    @FindBy(css = "#content p" )
    private WebElement resultSelector;


    @Override
    public String getUrl() {
        return null;
    }

    @Override
    protected void load() {

    }

//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(resultSelector)
//        .waitForElementIsClickable(resultSelector);
//    }

    public BasicAuthPage(){
        logger.info("Get Url");
        get(getUrlForAuth(USERNAME, PASSWORD));
    }

    public String getUrlForAuth(String username, String password) {
       return "http://" + username + ":" + password + URL ;
    }

    public String getResult(){
        return  resultSelector.getText();
    }
}
