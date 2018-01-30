import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.assertEquals;


public class DropdownTest extends BaseTest {
    private DropDownPage dropDownPage;

//    @BeforeMethod
//    public void setUp() {
//        dropDownPage = new DropDownPage();
//        // Opened BeforeMethod from here
//    }
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void dropdownSelect() {
        dropDownPage = new DropDownPage();
        dropDownPage.selectValue("Option 1");
        assertEquals(dropDownPage.getSelectedValue(), "Option 1");
        dropDownPage.selectValue("Option 2");
        assertEquals(dropDownPage.getSelectedValue(), "Option 2");

    }




}
