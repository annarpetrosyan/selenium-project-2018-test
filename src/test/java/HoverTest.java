import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class HoverTest extends BaseTest {
    private HoverPage hoverPage;

//    @BeforeMethod
//    public void setUp() {
//        hoverPage = new HoverPage();
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void hoverPageTest() {
        hoverPage = new HoverPage();
        assertTrue(hoverPage.isHeaderNotDisplayed(),"Header was not visible!");
        hoverPage.hoverAvatar(1);
        assertFalse(hoverPage.isHeaderDisplayed(),"Header was visible!");
    }

}
