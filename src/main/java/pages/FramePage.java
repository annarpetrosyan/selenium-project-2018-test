package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class FramePage extends BasePage {

    private String frameId = "mce_0_ifr";
    private String textEditorId = "tinymce";
    //
    /**
     * This is constructor
     *
     * @param webDriver
     */
    public FramePage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/tinymce");
    }

    /**
     *
     */
    public void changeFrame(){
        driver.switchTo().frame(frameId);
    }

    public void fillTextInTextEditor(String text){
        findElement(By.tagName("body")).sendKeys(text);
    }



}
