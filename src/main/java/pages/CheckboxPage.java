package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class CheckboxPage extends BasePage {

    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBys(
            @FindBy(css="input[type='checkbox']")
    )
    private List<WebElement> checkBoxes;


    @FindBy(id = "checkboxes")
    private WebElement checkBoxesSelector;

    public void clickOnCheckboxx(String checkBoxName){
        for(WebElement checkbox: checkBoxes){
            if(checkbox.getText().equals(checkBoxName)){
                checkbox.click();
            }
        }
    }
    public  CheckboxPage(){
        logger.info("Get URL for Checkbox page");
        get(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().waitForElementIsVisible(checkBoxesSelector);
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/checkboxes";
    }

    public void checkOnCheckboxByIndex(int indexNumber){
        getCheckBoxElementByIndex(checkBoxesSelector, indexNumber).click();

    }

    public boolean isCheckedCheckboxByIndex(int indexNumber){
        return getAttributeOfCheckbox(checkBoxesSelector, indexNumber);
    }

    public void uncheckCheckboxByIndex(int indexNumber){
        uncheckCheckboxElementByIndex(checkBoxesSelector, indexNumber);
    }

}
