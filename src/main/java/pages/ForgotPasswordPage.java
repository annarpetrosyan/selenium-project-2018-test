package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class ForgotPasswordPage extends BasePage {

    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(id = "email")
    private WebElement emailSelector;

    @FindBy(id = "form_submit")
    private WebElement retrievePasswordButtonId;

    @FindBy(id = "content")
    private WebElement resultContentId;


    public ForgotPasswordPage(){
        logger.info("Get Url of Page");
        get(getUrl());
    }


    @Override
    public String getUrl() {
        logger.info("Generate URL");
        return BASE_URL + "/forgot_password";
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(emailSelector)
                .waitForElementIsClickable(emailSelector);
    }



    public void fillEmail(String value){
        logger.info("Fill e-mail field");
        fill(emailSelector, value);
    }

    public void clickOnRetrievePassword(){
        logger.info("Click on Retrieve Password button");
        click(retrievePasswordButtonId);
    }

    public String getResult(){
        logger.info("Get text after retrieve action");
        return getText(resultContentId);
    }


    public String getErrorOfPage(){
        logger.info("Get Error text of Whole page");
        return getText(find(By.tagName("h1")));
    }
}
