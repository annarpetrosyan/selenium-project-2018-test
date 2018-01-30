import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RedirectLinksPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class RedirectLinksTest extends BaseTest{
    private RedirectLinksPage redirectLinksPage;

    @BeforeMethod
    public void setUp(){
        redirectLinksPage = new RedirectLinksPage();

    }

//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void redirectLinksTest(){
        redirectLinksPage.clickOnHere();
//        redirectLinksPage.switchToWindowByIndex(1);
//        redirectLinksPage.clickOnStatusCode("301");
//        assertTrue(redirectLinksPage.getMessageInOpenedPageOfStatus().contains("This page returned a 301 status code."), "Different Messages");
    }
}
