package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FileDownloadPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    public static String downloadPath = "C:\\test";

    @FindBy(id = "content")
    private WebElement divOfDownloadsSelector;

    public FileDownloadPage(){
        logger.info("Get URL of Page");
        get(getUrl());
    }


    @Override
    public String getUrl() {
        logger.info("Generate URL of Page");
        return BASE_URL + "/download";
    }

    @Override
    protected void load() {
    }

//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(divOfDownloadsSelector)
//                .waitForElementIsClickable(divOfDownloadsSelector);
//    }


    public void clickOnFile(String fileName){
        List<WebElement> href = divOfDownloadsSelector.findElements(By.tagName("a"));
        for(int j = 0; j < href.size(); j++){
            if(href.get(j).getText().contains(fileName)) {
                click(href.get(j));
                break;
            }
        }
    }



}
