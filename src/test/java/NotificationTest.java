import org.testng.annotations.Test;
import pages.NotificationMessagesPage;


public class NotificationTest extends BaseTest {
    private NotificationMessagesPage notificationMessagesPage;

//    @BeforeMethod
//    public void setUp() {
//        notificationMessagesPage = new NotificationMessagesPage();
//    }
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }
    /**
     * This is test for Status Codes
     */
    @Test
    public void notificationPageTest(){
        notificationMessagesPage = new NotificationMessagesPage();
        notificationMessagesPage.clickOnClickHereLink();
        notificationMessagesPage.getCountOfClickForPass();
    }




}
