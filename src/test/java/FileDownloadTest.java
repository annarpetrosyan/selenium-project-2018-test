import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileDownloadTest extends BaseTest {
    private FileDownloadPage fileDownloadPage;

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
