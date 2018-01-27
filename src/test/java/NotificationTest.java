import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagesPage;


public class NotificationTest extends BaseTest {
    private NotificationMessagesPage notificationMessagesPage;

    @BeforeMethod
    public void setUp() {
        notificationMessagesPage = new NotificationMessagesPage();
    }

    /**
     * This is test for Status Codes
     */
    @Test
    public void notificationPageTest(){
        notificationMessagesPage.clickOnClickHereLink();
        notificationMessagesPage.getCountOfClickForPass();
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }


}
