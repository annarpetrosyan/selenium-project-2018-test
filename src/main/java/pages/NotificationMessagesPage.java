package pages;

import helper.BasePage;
import org.openqa.selenium.JavascriptExecutor;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class NotificationMessagesPage extends BasePage {

    private String notificationMessageId = "div #flash";
    private String clickHereHrefId = "#content div a";
    //
    /**
     * This is constructor
     */
    public NotificationMessagesPage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl(){
        return BASE_URL + "/notification_message_rendered";
    }

    /**
     *
     * @return
     */
    public String getNotificationMessage(){
        return getText(notificationMessageId);
    }

    /**
     *  Click on Click Here link
     */
    public void clickOnClickHereLink() {
        click(clickHereHrefId);
    }


    int count = 0;

    /**
     *
     * @return
     */
    public Integer getCountOfClickForPass() {
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
