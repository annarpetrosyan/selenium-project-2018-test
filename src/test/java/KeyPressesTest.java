import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/22/2018.
 */
public class KeyPressesTest  extends BaseTest{
    private KeyPressesPage keyPressesPage;

    @BeforeMethod
    public void setUp(){
        keyPressesPage = new KeyPressesPage();
    }


    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void keyPressTest(){
        keyPressesPage.pressOnKey("ENTER");
        assertTrue(keyPressesPage.getResult().contains("ENTER"),"Default message");

    }

}
