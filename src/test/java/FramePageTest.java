import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramePage;


public class FramePageTest extends BaseTest {
    private FramePage framePage;

    @BeforeMethod
    public void setUp() {
        framePage = new FramePage();
    }
    /**
     * This is test for Status Codes
     */
    @Test
    public void framePageTest(){
        framePage.changeFrame();
        framePage.fillTextInTextEditor("This is text");
    }

//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }


}
