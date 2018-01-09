package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DropDownPage extends BasePage {
    private  String dropdownId = "dropdown";



    public DropDownPage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/dropdown";
    }

    /**
     * Get Drop down Webelement
     * @return
     */
    public WebElement getDropDown(){
        return find(By.id(dropdownId));
    }

    /**
     * Get all options of drop down
     * @return
     */
    public List<WebElement> getElements(){
        return getDropDown().findElements(By.tagName("option"));
    }

    /**
     *  select value by
     * @param value
     */
    public void selectValue(String value){
        List<WebElement> elements = getElements();
        for(WebElement element:elements){
            if(element.getText().equals(value)){
                element.click();
            }
        }
    }

    public String getSelectedValue(){
        List<WebElement> elements = getElements();
        for(WebElement element:elements){
            if(element.isSelected()){
              return element.getText();
            }
        }
        return null;
    }

    public void forceAlert() {
        ((JavascriptExecutor) driver).executeScript("alert('Hello! I am an alert box!!');");
    }
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }



}
