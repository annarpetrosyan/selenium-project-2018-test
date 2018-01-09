import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;

import static org.testng.AssertJUnit.assertEquals;


public class AlertTest extends BaseTest {
    private AlertPage alertPage;

    @BeforeMethod
    public void setUp() {
        alertPage = new AlertPage();

    }

//    @Test
//    public void createdAlertTest(){
//        alertPage.createTempAlert("Text for 1st alert");
//        alertPage.closeAlert();
//    }
//
//    @Test
//    public void alertOfPageTest(){
//        alertPage = new AlertPage();
//        alertPage.clickOn("Click for JS Alert");
//        alertPage.closeAlert();
//        assertEquals(alertPage.getResult(), "You successfully clicked an alert");
//    }
//
//    @Test
//    public void dismissAlertTest(){
//        alertPage = new AlertPage();
//        alertPage.clickOn("Click for JS Confirm");
//        alertPage.dismissAlert();
//        assertEquals(alertPage.getResult(), "You clicked: Cancel");
//    }



    @Test
    public void confirmAlertTest(){
        alertPage = new AlertPage();
        alertPage.clickOn("Click for JS Confirm");
        alertPage.confirmAlert();
        assertEquals(alertPage.getResult(), "You clicked: Ok");
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

}
