package pages;

import helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

import static setup.DriverSetup.initDriver;

/**
 * Created by anna.r.petrosyan on 1/29/2018.
 */
public class RedirectLinksPage  extends BasePage{

    @FindBy(id = "redirect")
    private WebElement hereLinkSelector;

    public RedirectLinksPage(){
        logger.info("Get URL for Redirect Links page");
        get(getUrl());
    }
    @Override
    public String getUrl() {
        return BASE_URL + "/redirector";
    }


    public void clickOnHere(){
        logger.info("Click On Here");
        click(hereLinkSelector);
    }

    public void switchToWindowByIndex(int indexNumber){
        Set<String> allHandles = initDriver().getWindowHandles();
        int windowsCount = allHandles.size()-1;
        for (int i=0; i < windowsCount; i++){
            if(i == indexNumber){
                String handle =  allHandles.toArray()[i].toString();
                initDriver().switchTo().window(handle);
            }
        }
    }

}
