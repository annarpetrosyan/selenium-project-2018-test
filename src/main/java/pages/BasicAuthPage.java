package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class BasicAuthPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    final String URL = "@the-internet.herokuapp.com/basic_auth";


    @FindBy(css = "#content p" )
    private WebElement resultSelector;


    @Override
    public String getUrl() {
        return null;
    }

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
