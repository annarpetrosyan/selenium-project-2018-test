package pages;

import helper.BasePage;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class FramePage extends BasePage {

    private String frameId = "mce_0_ifr";
    private String textEditorTagName = "body";

    //
    /**
     * This is constructor
     *
     */
    public FramePage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl(){
        return BASE_URL + "/tinymce";
    }

    /**
     *
     */
    public void changeFrame(){
        driver.switchTo().frame(frameId);
    }

    public void fillTextInTextEditor(String text){
        find(textEditorTagName).clear();
        find(textEditorTagName).sendKeys(text);
    }



}
