package helper;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/24/2018.
 */
public class CommonVisibilityTypes {

    public static CommonVisibilityTypes isLoaded(){
        CommonVisibilityTypes commonMethodsHelper = new CommonVisibilityTypes();
        return commonMethodsHelper;
    }

    private CommonVisibilityTypes isElementVisible(WebElement webElement){
        try{
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(webElement));
            return this;
        }catch (WebDriverException e){
            throw new Error("Element is not visible");
        }
    }

    private CommonVisibilityTypes isElementClickable(WebElement webElement){
        try{
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(webElement));
            return this;
        }catch (WebDriverException e){
            throw new Error("Element is not clickable");
        }
    }


    private CommonVisibilityTypes isElementSelected(WebElement webElement){
        try{
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeSelected(webElement));
            return this;
        }catch (WebDriverException e){
            throw new Error("Element is not selected");
        }
    }
}
