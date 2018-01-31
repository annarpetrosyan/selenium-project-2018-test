import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import setup.listeners.SuiteListener;

import static setup.DriverSetup.initDriver;
import static setup.DriverSetup.quitDriver;
@Listeners(SuiteListener.class)
public abstract class BaseTest {
    @BeforeMethod
    public void setUpBase() {
        initDriver();
    }

    @AfterClass
    public void tearDownBase() {
        quitDriver();
    }
}
