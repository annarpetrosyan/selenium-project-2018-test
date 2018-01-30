package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DropDownPage extends BasePage {
    @FindBy(id = "dropdown")
    private WebElement dropdownId;

    Logger logger = Logger.getLogger(Log.class.getName());


    public DropDownPage() {
        logger.info("Get Url");
        get(getUrl());
    }


    public String getUrl() {
        logger.info("generate URL");
        return BASE_URL + "/dropdown";
    }

    @Override
    protected void load() {
    }

//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(dropdownId)
//                .waitForElementIsClickable(dropdownId);
//    }

    /**
     * Get Drop down Webelement
     * @return
     */
    public WebElement getDropDown(){
        logger.info("Get Dropdown");
        return dropdownId;
    }

    /**
     * Get all options of drop down
     * @return
     */
    public List<WebElement> getElements(){
        logger.info("Find elements of select and keep it in List");
        return getDropDown().findElements(By.tagName("option"));
    }

    /**
     *  select value by
     * @param value
     */
    public void selectValue(String value){
        logger.info("Select drop down value. Value = " + value);
        List<WebElement> elements = getElements();
        for(WebElement element:elements){
            if(element.getText().equals(value)){
                element.click();
            }
        }
    }

    public String getSelectedValue(){
        logger.info("Get text for selected value of drop down");
        List<WebElement> elements = getElements();
        for(WebElement element:elements){
            if(element.isSelected()){
              return element.getText();
            }
        }
        return null;
    }

    public void forceAlert() {
        logger.info("Generate alert by executing js script");
        ((JavascriptExecutor) driver).executeScript("alert('Hello! I am an alert box!!');");
    }

    public void closeAlert() {
        logger.info("Generate alert, Accept it");
        driver.switchTo().alert().accept();
    }



}
