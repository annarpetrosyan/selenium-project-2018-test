package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DropDownPage extends BasePage {
    private  String dropdownId = "dropdown";

    /**
     * This is constructor
     *
     * @param webDriver
     */
    public DropDownPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/dropdown");
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



}
