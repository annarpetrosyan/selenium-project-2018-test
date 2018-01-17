package pages;

import helper.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DataTablesPage extends BasePage {
    Logger logger = Logger.getLogger(Log.class.getName());

    @FindBy(id = "table1")
    private WebElement table1Selector;

    @FindBy(id = "table2")
    private WebElement table2Selector;

    public DataTablesPage(){
     logger.info("Get Url");
     get(getUrl());
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/tables";
    }

    public WebElement getElementByRowCellNumbersForTable1(int rowNumber, int columnNumber){
        return getTableColumnElementByRowNumberCellNumber(table1Selector, rowNumber, columnNumber);
    }

    public WebElement getElementByRowCellNumbersForTable2(int rowNumber, int columnNumber){
        return getTableColumnElementByRowNumberCellNumber(table2Selector, rowNumber, columnNumber);
    }

    public void sortTable1ByCellIndex(int cellIndex){
        clickOnTableHeaderByWebElementRowNumberColumnNumber(table1Selector, 1, cellIndex);
    }

    public void sortTable2ByCellIndex(int cellIndex){
        clickOnTableHeaderByWebElementRowNumberColumnNumber(table2Selector, 1, cellIndex);
    }
}
