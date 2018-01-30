import org.testng.annotations.Test;
import pages.FramePage;


public class FramePageTest extends BaseTest {
    private FramePage framePage;

//    @BeforeMethod
//    public void setUp() {
//        framePage = new FramePage();
//    }
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }
    /**
     * This is test for Status Codes
     */
    @Test
    public void framePageTest(){
        framePage = new FramePage();
        framePage.changeFrame();
        framePage.fillTextInTextEditor("This is text");
    }




}
