import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUp(){
        fileUploadPage = new FileUploadPage();
    }

//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }

    @Test
    public void fileUploadPageTest() throws IOException {
        Path filePath = Files.createTempFile("testFiles", ".txt");
        File file = filePath.toFile();
        String path = file.getAbsolutePath();
        fileUploadPage.attachFileInPage(path);
        fileUploadPage.clickOnSubmit();

        assertTrue(fileUploadPage.getUpladedFiles().contains(file.getName()), "File di not uploaded!");
    }
}
