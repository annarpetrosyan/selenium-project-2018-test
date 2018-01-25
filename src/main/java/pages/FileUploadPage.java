package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileUploadPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    private static final String browsFilePath = "C:\\test\\";


    @FindBy(id = "file-upload")
    private WebElement inputUploadSelector;

    @FindBy(id = "file-submit")
    private WebElement fileSubmitButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    public FileUploadPage(){
        logger.info("Get URL of Page");
        get(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(fileSubmitButton)
                .waitForElementIsClickable(fileSubmitButton);
    }

    @Override
    public String getUrl() {
        logger.info("Generate URL of Page");
        return BASE_URL + "/upload";
    }


    public void attachFileInPage(String path) {
        fill(inputUploadSelector, path);
    }


    public void clickOnSubmit(){
        click(fileSubmitButton);
    }

    public String getUpladedFiles(){
        return getText(uploadedFiles);
    }
}
