package setup.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.initDriver;

public class SuiteListener extends TestListenerAdapter{

    private static Logger logger = Logger.getLogger(SuiteListener.class.getName());

    @Override
    public void onTestFailure(ITestResult currentTest){
        logger.info("Taking screenshot on Failure");

        File scrFile =  ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File screenshotName = new File(".\\target\\screenshots\\" + currentTest.getName() + "_"+ timeStamp + ".png");

        try{
            FileUtils.copyFile(scrFile,screenshotName);
        }catch (IOException e){
            e.printStackTrace();
        }
        logger.info("-------------------");
        logger.info("FAILED -- > " + currentTest.getName());
        logger.info("-------------------");
    }


    @Override
    public void onTestStart(ITestResult currentTest){
        logger.info("------------------");
        logger.info("STARTED to RUN ---> " +currentTest.getName());
    }

    @Override
    public void onTestSuccess(ITestResult currentTest){
        logger.info("-------------------------");
        logger.info("Finished ----> " + currentTest.getName());
        logger.info("--------------------------");
    };

}
