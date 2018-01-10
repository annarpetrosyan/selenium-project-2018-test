package pages;

import helper.BasePage;
import org.openqa.selenium.WebElement;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class DragDropPage extends BasePage {
       private String webElementASelector = "div #column-a";
       private String webElementBSelector = "div #column-b";

    public DragDropPage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/drag_and_drop";
    }


    public void dragAndDrop(String elem1, String elem2){
        WebElement webElementA = find(webElementASelector);
        WebElement webElementB = find(webElementBSelector);
       if(elem1=="A" && elem2=="B"){
           dragAndDrop(webElementA, webElementB);
        }else if(elem1=="B" && elem2=="A"){
           dragAndDrop(webElementB,webElementA);
        }
    }

}
