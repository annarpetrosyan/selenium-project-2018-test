package pages;

import helper.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class NotificationMessagesPage extends BasePage {

    private String notificationMessageId = "div #flash";
    private String clickHereHrefId = "#content div a";
    //
    /**
     * This is constructor
     *
     * @param webDriver
     */
    public NotificationMessagesPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/notification_message_rendered");
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
