import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileDownloadTest extends BaseTest {
    private FileDownloadPage fileDownloadPage;
 // --// TODO: 1/17/2018 Download arel em, check chem arel
    @BeforeMethod
    public void setUp(){
        fileDownloadPage = new FileDownloadPage();
    }

//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void fileDownloadPageTest(){
        fileDownloadPage.clickOnFile("test.txt");
    }
}
