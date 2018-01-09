package pages;

import helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DragDropPage extends BasePage {
       private String webElementASelector = "div #column-a";
        private String getWebElementBSelector = "div #column-b";

    public DragDropPage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/drag_and_drop";
    }


    public void dragAndDrop(String elem1, String elem2){
        WebElement webElementA = find(webElementASelector);
        WebElement webElementB = find(getWebElementBSelector);
        Actions actions = new Actions(driver);
        if(elem1=="A" && elem2=="B"){
            Action dragAndDrop = actions.clickAndHold(webElementA).moveToElement(webElementB).release(webElementB).build();
            dragAndDrop.perform();
        }else if(elem1=="B" && elem2=="A"){
            actions.dragAndDrop(webElementB,webElementA);
        }

    }


}
