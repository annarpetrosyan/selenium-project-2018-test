import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.assertEquals;


public class DropdownTest extends BaseTest {
    private DropDownPage dropDownPage;

    @BeforeMethod
    public void setUp() {
        dropDownPage = new DropDownPage();

    }

    @Test
    public void dropdownSelect() {
        dropDownPage.selectValue("Option 1");
        assertEquals(dropDownPage.getSelectedValue(), "Option 1");
        dropDownPage.selectValue("Option 2");
        assertEquals(dropDownPage.getSelectedValue(), "Option 2");

    }


    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

}
