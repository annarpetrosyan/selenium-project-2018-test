import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;

public class DragDropTest extends BaseTest {
    private DragDropPage dragDropPage;

    @BeforeMethod
    public void setUp() {
        dragDropPage = new DragDropPage();
    }
////
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }
//
    @Test
    public void setDragDropTest(){
        dragDropPage.dragAndDrop();
       }



}
