import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DataTablesPage;

/**
 * Created by anna.r.petrosyan on 1/17/2018.
 */
public class DataTablesTest extends BaseTest {
    private DataTablesPage dataTablesPage;


//    @BeforeMethod
//    public void setUp(){
//        dataTablesPage = new DataTablesPage();
//    }
    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }

    @Test
    public void setDataTablesPageTest(){
        dataTablesPage = new DataTablesPage();
        System.out.println(dataTablesPage.getElementByRowCellNumbersForTable1(1, 2).getText());
        System.out.println(dataTablesPage.getElementByRowCellNumbersForTable2(1, 2).getText());
        dataTablesPage.sortTable1ByCellIndex(2);
        dataTablesPage.sortTable2ByCellIndex(3);

    }

}
