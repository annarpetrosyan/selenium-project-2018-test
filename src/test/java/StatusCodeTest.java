import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StatusCodesPage;

import static org.testng.Assert.assertEquals;


public class StatusCodeTest extends BaseTest {
    private StatusCodesPage statusCodesPage;

    @BeforeMethod
    public void setUp() {
        statusCodesPage = new StatusCodesPage();

    }


    /**
     * This is test for Status Codes
     */
    @Test
    public void statusCodesTest(){
        statusCodesPage = new StatusCodesPage();
        assertEquals(statusCodesPage.getHeaderText(), "Status Codes", "Different Headers");
        statusCodesPage.clickOnStatusCode("500");
        assertEquals(statusCodesPage.getMessageInOpenedPageOfStatus(), "This page returned a 500 status code.", "Different Messages");
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }


}
