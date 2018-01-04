package pages;

import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class AlertPage extends BasePage {

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


    public void clickOn(String buttonName){
        switch(buttonName){
            case "JS Alert":{
                  findElement(By.xpath("button[contains(text(),'Click for JS Alert'))]"));
            }
            case "JS Confirm":{
                click(By.xpath("button[contains(text(),"+buttonName+"))]"));
            }
            case "JS Prompt":{
                click(By.xpath("button[contains(text(),"+buttonName+"))]"));
            }
            default:{
                System.out.println("There is no button with" +buttonName+ " name.");
            }
        }
    }


}
