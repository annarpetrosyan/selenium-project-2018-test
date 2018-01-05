import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by anna.r.petrosyan on 1/4/2018.
 */
public class TestClassAllFunctionality {
    private ChromeDriver webDriver;
    private MultiWindowPage multiWindowPage;
    private AlertPage alertPage;
    private HoverPage hoverPage;
    private FramePage framePage;
    private DropDownPage dropDownPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }

//    /**
//     * This is test for multi window
//     */
//    @Test
//    public void multiWindowPage(){
//        multiWindowPage = new MultiWindowPage(webDriver);
//        multiWindowPage.clickOnClickHereLink();
//        multiWindowPage.switchToWindow(0);
//    }
//
//    /**
//     * This test Frame changing ---------
//     */
//
//    @Test
//    public void dropDownTest(){
//        framePage = new FramePage(webDriver);
//        framePage.changeFrame();
//        framePage.fillTextInTextEditor("This is text");
//
//    }
//
//    @Test
//    public void dropDownTest(){
//        dropDownPage = new DropDownPage(webDriver);
//        dropDownPage.selectValue("Option 1");
//        assertEquals(dropDownPage.getSelectedValue(), "Option 1");
//        dropDownPage.selectValue("Option 2");
//        assertEquals(dropDownPage.getSelectedValue(), "Option 1");
//    }
//
//
//    @Test
//    public void createdAlertTest(){
//        alertPage = new AlertPage(webDriver);
//        alertPage.createTempAlert("Text for 1st alert");
//        alertPage.closeAlert();
//    }
//
//    @Test
//    public void alertOfPageTest(){
//        alertPage = new AlertPage(webDriver);
//        alertPage.clickOn("Click for JS Alert");
//        alertPage.closeAlert();
//        assertEquals(alertPage.getResult(), "You successfully clicked an alert");
//    }
//
//    @Test
//    public void dismissAlertTest(){
//        alertPage = new AlertPage(webDriver);
//        alertPage.clickOn("Click for JS Confirm");
//        webDriver.switchTo().alert().dismiss();
//        assertEquals(alertPage.getResult(), "You clicked: Cancel");
//    }
//
//    @Test
//    public void confirmAlertTest(){
//        alertPage = new AlertPage(webDriver);
//        alertPage.clickOn("Click for JS Confirm");
//        webDriver.switchTo().alert().accept();
//        assertEquals(alertPage.getResult(), "You clicked: Ok");
//    }

    /**
     * This test for Hover --todo
     */
    @Test
    public void hoversTest(){
        hoverPage = new HoverPage(webDriver);
        assertTrue(hoverPage.isHeaderNotDisplayed(),"Header was not visible!");
        hoverPage.hoverAvatar(1);
        assertTrue(hoverPage.isHeaderDisplayed(),"Header was visible!");

    }



}
