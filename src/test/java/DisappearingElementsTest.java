import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DisappearingElementsPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DisappearingElementsTest extends BaseTest {
    private DisappearingElementsPage disappearingElementsPage;

    @BeforeMethod
    public void setUp(){
        disappearingElementsPage = new DisappearingElementsPage();
    }
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void setDisappearingElementsPageTest(){
        disappearingElementsPage.getMenuWebElementByIndex(1); // indexNumber = 1 == Home, indexNumber = 2 == About, etc.
        assertTrue(disappearingElementsPage.getMenuWebElementByIndex(1).getText().equals("Home"), "Assertion Error!");
//        assertFalse(disappearingElementsPage.isDisplayedLatestContentOfMenuGallery(),"Latest Menu item is missing");
//        System.out.println("Result for Latest Element of Menu = " + disappearingElementsPage.getTextOfLatestElementIfExist());
//        disappearingElementsPage.clickOnMenuByIndexNumber(1);
    }


}
