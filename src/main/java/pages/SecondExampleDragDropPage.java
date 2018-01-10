package pages;

import helper.BasePage;
import org.openqa.selenium.WebElement;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class SecondExampleDragDropPage extends BasePage {
       private String elementASelector = "div#draggable";
       private String elementBSelector = "div#droppable";
       private String invalidDroppableSelector = "body";

    public SecondExampleDragDropPage() {
        super(getDriver());
        get(getUrl());
    }

    public String getUrl() {
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    public void dragAndDropSecondExample(String elem1, String elem2){
        WebElement elementA = find(elementASelector);
        WebElement elementB = find(elementBSelector);
        WebElement invalidElement = find(invalidDroppableSelector);
        if(elementA.getText().equals(elem1) && elementB.getText().equals(elem2)){
            dragAndDrop(elementA, elementB);
        }else {
            dragAndDrop(elementB,invalidElement);
        }
    }

    public String getDroppableText(){
        return getText(elementBSelector);
    }

}
