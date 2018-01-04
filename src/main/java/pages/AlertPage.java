package pages;

import helper.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class AlertPage extends BasePage {

    private String resultId = "#result";
    //
    /**
     * This is constructor
     *
     * @param webDriver
     */
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
        get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void createTempAlert(String message){
        ((JavascriptExecutor) driver).executeScript("alert('"+message+"');");
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }


    /**
     * Execute alert
     * @param buttonName
     */
    public void clickOn(String buttonName){
        switch(buttonName){
            case "Click for JS Alert":{
                //
                ((JavascriptExecutor) driver).executeScript("jsAlert()");
//                findElement(By.cssSelector("#content > div > ul button"));
//                  findElement(By.xpath("button[contains(text(),'Click for JS Alert'))]"));
                break;
            }
            case "Click for JS Confirm":{
                ((JavascriptExecutor) driver).executeScript("jsConfirm()");
//                click(By.xpath("button[contains(text(),"+buttonName+"))]"));
                break;
            }
            case "Click for JS Prompt":{
                ((JavascriptExecutor) driver).executeScript("jsPrompt()");
//                click(By.xpath("button[contains(text(),"+buttonName+"))]"));
                break;
            }
            default:{
                System.out.println("There is no button with" +buttonName+ " name.");
            }
        }
    }


    public String getResult(){
        return find(resultId).getText();
    }



}
