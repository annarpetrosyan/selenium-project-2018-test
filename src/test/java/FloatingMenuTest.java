import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FloatingMenuTest extends  BaseTest{
    private FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setUp(){
        floatingMenuPage = new FloatingMenuPage();
    }

//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void setFloatingMenuPageTest(){
        floatingMenuPage.selectMenuByName("Home");
        floatingMenuPage.selectMenuByName("About");

    }

}
