package pages;

import helper.BasePage;

import static setup.DriverSetup.getDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class MultiWindowPage extends BasePage {
    private String hrefcssSelector = ".example a";

    /**
     * This is constructor
     *
     *
     */
    public MultiWindowPage( ) {
       super(getDriver());
        get(getUrl());
    }
    public String getUrl(){
        return BASE_URL + "/windows";
    }
    /**
     * Click on Click here link
     */
    public void clickOnClickHereLink(){
        find(hrefcssSelector).click();
    }

    /**
     *  Take all windows ans set in array
     * @return
     */
    public Object[] getAllWindows(){
        return driver.getWindowHandles().toArray();
    }

    /**
     * Switch to window
     * @param index
     */
    public void switchToWindow(int index){
        driver.switchTo().window(getAllWindows()[index].toString());
    }



}
