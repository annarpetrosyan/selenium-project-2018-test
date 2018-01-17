import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasicAuthPage;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class BasicAuthTest extends BaseTest {
    private BasicAuthPage basicAuthPage;

    @BeforeMethod
    public void setUp(){
        basicAuthPage = new BasicAuthPage();
    }


    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void basicAuthPageTest(){
        assert(basicAuthPage.getResult().contains("Congratulations! You must have the proper credentials."));
    }
}
