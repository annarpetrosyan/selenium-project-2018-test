package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class NotificationMessagesPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(css = "div #flash")
    private WebElement notificationMessageId;

    @FindBy(css = "#content div a")
    private WebElement clickHereHrefId;
    //
    /**
     * This is constructor
     */
    public NotificationMessagesPage() {
        logger.info("Constructor");
        get(getUrl());
    }

    public String getUrl(){
        logger.info("Generate URL");
        return BASE_URL + "/notification_message_rendered";
    }

    /**
     *
     * @return
     */
    public String getNotificationMessage(){
        logger.info("Get Notification Text");
        return getText(notificationMessageId);
    }

    /**
     *  Click on Click Here link
     */
    public void clickOnClickHereLink() {
        logger.info("Click on Here link");
        click(clickHereHrefId);
    }


    int count = 0;

    /**
     *
     * @return
     */
    public Integer getCountOfClickForPass() {
        logger.info("Condition for Action Successfully state");
        if(getNotificationMessage().equals("Action successful")){
            ((JavascriptExecutor) driver).executeScript("alert('Action successful - Test Passed!');");
        }else{
            count++;
            clickOnClickHereLink();
            getCountOfClickForPass();
        }
       return count;
    }
}
