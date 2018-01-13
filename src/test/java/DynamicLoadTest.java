import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/13/2018.
 */
public class DynamicLoadTest extends BaseTest{

    private DynamicLoadPage dynamicLoadPage;

    @BeforeMethod
    public void setUp(){
        dynamicLoadPage = new DynamicLoadPage();
    }


    @Test
    public void dynamicLoad() {
        dynamicLoadPage.clickOnStart();
        assertTrue(dynamicLoadPage.isLoadingDisplayed());
        assertTrue(dynamicLoadPage.isLoadingNotDisplayed());
        assertTrue(dynamicLoadPage.isFinishDisplayed());
        assertEquals(dynamicLoadPage.getFinish().getText(), "Hello World!");
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }
}
