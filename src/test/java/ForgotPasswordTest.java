import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class ForgotPasswordTest extends  BaseTest{
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUp(){
        forgotPasswordPage = new ForgotPasswordPage();
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void forgotPasswordPageTest(){
        forgotPasswordPage.fillEmail("test@test.com");
        forgotPasswordPage.clickOnRetrievePassword();
        assertTrue(forgotPasswordPage.getResult().contains("Your e-mail's been sent!"));

    }

    @Test
    public void forgotPasswordPageNegativeTest(){
        forgotPasswordPage.clickOnRetrievePassword();
        assertTrue(forgotPasswordPage.getErrorOfPage().contains("Internal Server Error"));

    }

}
