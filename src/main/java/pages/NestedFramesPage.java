package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class NestedFramesPage extends BasePage{

    @FindBy(name = "frame-bottom")
    private WebElement bottomFrame;


    @FindBy(name = "frame-top")
    private WebElement topFrame;

    public NestedFramesPage(){
        get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/nested_frames";
    }


    public void switchToBottomFrame(){
        getDriver().switchTo().frame(bottomFrame);
    }


    public String getTextOfFrame(){
       return find(By.tagName("body")).getText();
    }

    public void switchMiddleFrameByIndex(int indexNumber){
        List<WebElement> frames = findElems(By.cssSelector("frameset[name='frameset-middle'] > frame"));
        getDriver().switchTo().frame(frames.get(indexNumber).toString());
    }

}
