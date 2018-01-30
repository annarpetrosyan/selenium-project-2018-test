import org.testng.annotations.Test;
import pages.StatusCodesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class StatusCodeTest extends BaseTest {
    private StatusCodesPage statusCodesPage;

//    @BeforeMethod
//    public void setUp() {
//        statusCodesPage = new StatusCodesPage();
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    /**
     * This is test for Status Codes
     */
    @Test
    public void statusCodesTest(){
        statusCodesPage = new StatusCodesPage();
        statusCodesPage = new StatusCodesPage();
        assertEquals(statusCodesPage.getHeaderText(), "Status Codes", "Different Headers");
        statusCodesPage.clickOnStatusCode("500");
        assertTrue(statusCodesPage.getMessageInOpenedPageOfStatus().contains("This page returned a 500 status code."), "Different Messages");
    }



}
