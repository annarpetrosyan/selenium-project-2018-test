import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RedirectLinksPage;
import pages.StatusCodesPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class RedirectLinksTest extends BaseTest{
    private RedirectLinksPage redirectLinksPage;
    private StatusCodesPage statusCodesPage;

    @BeforeMethod
    public void setUp(){
        redirectLinksPage = new RedirectLinksPage();

    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void redirectLinksTest(){
        // TODO - stex incha asum?????
        redirectLinksPage.clickOnHere();
        redirectLinksPage.switchToWindowByIndex(1);
        statusCodesPage = new StatusCodesPage();
        statusCodesPage.clickOnStatusCode("301");
        assertTrue(statusCodesPage.getMessageInOpenedPageOfStatus().contains("This page returned a 301 status code."), "Different Messages");
    }
}
