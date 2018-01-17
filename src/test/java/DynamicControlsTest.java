import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DynamicControlsTest extends BaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUp(){
        dynamicControlsPage = new DynamicControlsPage();
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void dynamicControlsTest(){
        dynamicControlsPage.checkTheCheckbox();
        dynamicControlsPage.clickOnAddRemoveButton();
        assertTrue(dynamicControlsPage.isLoadingDisplayed());
        assertTrue(dynamicControlsPage.isNotLoadingDisplayed());
        assertEquals(dynamicControlsPage.getResultAfterLoading(), "It's gone!");
        dynamicControlsPage.clickOnAddRemoveButton();
        assertTrue(dynamicControlsPage.isLoadingDisplayed());
        assertTrue(dynamicControlsPage.isNotLoadingDisplayed());
        assertEquals(dynamicControlsPage.getResultAfterLoading(), "It's back!");
    }
}
