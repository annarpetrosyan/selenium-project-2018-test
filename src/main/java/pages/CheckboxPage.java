package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class CheckboxPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(id = "checkboxes")
    private WebElement checkBoxesSelector;

    public  CheckboxPage(){
        logger.info("Get URL for Checkbox page");
        get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/checkboxes";
    }

    public void checOnCheckboxByIndex(int indexNumber){
        getCheckBoxElementByIndex(checkBoxesSelector, indexNumber).click();

    }

    public boolean isCheckedCheckboxByIndex(int indexNumber){
        return getAttributeOfCheckbox(checkBoxesSelector, indexNumber);
    }

    public void uncheckCheckboxByIndex(int indexNumber){
        uncheckCheckboxElementByIndex(checkBoxesSelector, indexNumber);
    }

}
