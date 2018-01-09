import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.Assert.assertTrue;


public class HoverTest extends BaseTest {
    private ChromeDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        hoverPage = new HoverPage();

    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void dropdownSelect() {
       assertTrue(hoverPage.isHeaderNotDisplayed(),"Header was not visible!");
        hoverPage.hoverAvatar(1);
        assertTrue(hoverPage.isHeaderDisplayed(),"Header was visible!");
    }

}
