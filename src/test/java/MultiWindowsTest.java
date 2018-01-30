import org.testng.annotations.Test;
import pages.MultiWindowPage;


public class MultiWindowsTest extends BaseTest {
    private MultiWindowPage multiWindowPage;

//    @BeforeMethod
//    public void setUp() {
//        multiWindowPage = new MultiWindowPage();
//    }
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void windowChange() {
        multiWindowPage = new MultiWindowPage();
        multiWindowPage.clickOnClickHereLink();
        multiWindowPage.switchToWindow(0);
    }



}
