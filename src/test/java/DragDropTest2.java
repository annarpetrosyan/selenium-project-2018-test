import org.testng.annotations.Test;
import pages.SecondExampleDragDropPage;

import static org.testng.Assert.assertTrue;


public class DragDropTest2 extends BaseTest {
    private SecondExampleDragDropPage secondExampleDragDropPage;

//    @BeforeMethod
//    public void setUp() {
//        secondExampleDragDropPage =  new SecondExampleDragDropPage();
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        tearDownBase();
//    }
//
    @Test
    public void setDragDropTest() {
        secondExampleDragDropPage =  new SecondExampleDragDropPage();
        secondExampleDragDropPage.dragAndDropSecondExample();
        assertTrue(secondExampleDragDropPage.getDroppableText().contains("Dropped!"),"Assertion error!");
    }



}
