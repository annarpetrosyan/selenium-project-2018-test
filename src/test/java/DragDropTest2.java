import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SecondExampleDragDropPage;

import static org.testng.Assert.assertTrue;


public class DragDropTest2 extends BaseTest {
    private SecondExampleDragDropPage secondExampleDragDropPage;

    @BeforeMethod
    public void setUp() {
        secondExampleDragDropPage = new SecondExampleDragDropPage();

    }

    @Test
    public void setDragDropTest() {
//        secondExampleDragDropPage.dragAndDropSecondExample("Drag me to my target", "Drop here");
//        assertTrue(secondExampleDragDropPage.getDroppableText().contains("Dropped!"),"Assertion error!");
          secondExampleDragDropPage.dragAndDropSecondExample("Drag me to my target", "Invalid Place");
          assertTrue(secondExampleDragDropPage.getDroppableText().contains("Dropped!"),"Assertion error!");
 }

    @AfterMethod
    public void tearDown(){
        tearDownBase();
    }


}
