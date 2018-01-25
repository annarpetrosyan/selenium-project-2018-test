package pages;

import helper.BasePage;
import helper.CommonWaits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class AlertPage extends BasePage {

    @FindBy(id = "#result")
    private WebElement resultId ;


    public AlertPage() {
        logger.info("Constructor ");
        get(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        CommonWaits.getWait().
                waitForElementIsVisible(resultId)
                .waitForElementIsClickable(resultId);
    }


    public String getUrl(){
        logger.info("Get Url");
        return BASE_URL + "/javascript_alerts";
    }
    public void createTempAlert(String message){
        logger.info("Execute JS sccript, generate alert");
        ((JavascriptExecutor) driver).executeScript("alert('"+message+"');");
    }

    public void closeAlert(){
        logger.info("Switch to alert and accept it");
        driver.switchTo().alert().accept();
    }


    /**
     * Execute alert
     * @param buttonName
     */
    public void clickOn(String buttonName){
        logger.info("Click on Alert by name" + buttonName);
        switch(buttonName){
            case "Click for JS Alert":{
                ((JavascriptExecutor) driver).executeScript("jsAlert()");
                break;
            }
            case "Click for JS Confirm":{
                ((JavascriptExecutor) driver).executeScript("jsConfirm()");
                break;
            }
            case "Click for JS Prompt":{
                ((JavascriptExecutor) driver).executeScript("jsPrompt()");
                break;
            }
            default:{
                System.out.println("There is no button with" +buttonName+ " name.");
            }
        }
    }


    public String getResult(){
        logger.info("Get text of Result");
        return resultId.getText();
    }

    public void dismissAlert(){
        logger.info("Dismiss Alert");
        driver.switchTo().alert().dismiss();
    }

    public void confirmAlert(){
        logger.info("Confirm Alert");

        driver.switchTo().alert().accept();
    }


}
