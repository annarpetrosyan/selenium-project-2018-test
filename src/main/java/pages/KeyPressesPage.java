package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/22/2018.
 */
public class KeyPressesPage extends BasePage {

    @FindBy(id = "content")
    private WebElement contentSelector;


    @FindBy(id = "result")
    private WebElement resultSelector;

    public KeyPressesPage(){
        get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/key_presses" ;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().waitForElementIsVisible(contentSelector);
    }

    public void pressOnKey(String keyName) {
        Actions action = new Actions(getDriver());

        switch (keyName){
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                break;
            case "TAB":
                action.sendKeys(Keys.TAB).build().perform();
                break;
            case "ESCAPE":
                action.sendKeys(Keys.ESCAPE).build().perform();
                break;
            default:
                System.out.println("There is no " + keyName + " key in method.");
        }
    }

    public String getResult(){
       return getText(resultSelector);
    }


}
