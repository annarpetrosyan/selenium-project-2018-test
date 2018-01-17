import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUp(){
        fileUploadPage = new FileUploadPage();
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void fileUploadPageTest() throws InterruptedException {
        fileUploadPage.attachFileInPage("test.txt");

    }
}
