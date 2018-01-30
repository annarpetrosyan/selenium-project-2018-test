package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class FloatingMenuPage extends BasePage {
    @FindBy(id = "menu")
    private WebElement menuSelector;

    public FloatingMenuPage(){
        get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/floating_menu";
    }

    @Override
    protected void load() {

    }

//    @Override
//    protected void isLoaded() throws Error {
//        CommonWaits.getWait().
//                waitForElementIsVisible(menuSelector)
//                .waitForElementIsClickable(menuSelector);
//    }


    public void selectMenuByName(String tabName){
        switch (tabName){
            case "Home":
                getLiForUlByIndex(1).click();
                break;
            case "News":
                getLiForUlByIndex(2).click();
                break;
            case "Contact":
                getLiForUlByIndex(3).click();
                break;
            case "About":
                getLiForUlByIndex(4).click();
                break;
            default:
                System.out.println("There is no item in menu with name " + tabName);
        }
    }
}
