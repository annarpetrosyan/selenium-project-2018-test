import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;


public class DragDropTest extends BaseTest {
    private DragDropPage dragDropPage;

    @BeforeMethod
    public void setUp() {
        dragDropPage = new DragDropPage();

    }


    @Test
    public void statusCodesTest(){
        dragDropPage.dragAndDrop("A", "B");
    }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }


}
