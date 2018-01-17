package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileUploadPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    private static final String browsFilePath = "C:\\test\\";

// TODO take as value null
    @FindBy(id = "file-upload")
    private String inputUploadSelector;

    public FileUploadPage(){
        logger.info("Get URL of Page");
        get(getUrl());
    }

    @Override
    public String getUrl() {
        logger.info("Generate URL of Page");
        return BASE_URL + "/upload";
    }


    public void attachFileInPage(String fileName) throws InterruptedException {
        WebElement attachment = findElement(By.id(inputUploadSelector));
        attachment.sendKeys(browsFilePath + fileName);
        Thread.sleep(2000);
    }


}
