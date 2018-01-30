import org.testng.annotations.Test;
import pages.RedirectLinksPage;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class RedirectLinksTest extends BaseTest{
    private RedirectLinksPage redirectLinksPage;

//    @BeforeMethod
//    public void setUp(){
//        redirectLinksPage = new RedirectLinksPage();
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void redirectLinksTest(){
        redirectLinksPage = new RedirectLinksPage();
        redirectLinksPage.clickOnHere();
//        redirectLinksPage.switchToWindowByIndex(1);
    }

}
