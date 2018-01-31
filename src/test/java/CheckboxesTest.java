import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class CheckboxesTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void setUp(){
        checkboxPage = new CheckboxPage();
    }
//
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void checkboxPageTest(){
        checkboxPage.clickOnCheckboxx("checkbox 1");
        checkboxPage.checkOnCheckboxByIndex(1);
        assertTrue(checkboxPage.isCheckedCheckboxByIndex(1), "N/A");
        checkboxPage.uncheckCheckboxByIndex(2);
    }


}
