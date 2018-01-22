package setup.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {
    Logger logger = Logger.getLogger(RetryAnalyzer.class.getName());

    private int retryCount = 0;
    private int maxRetryCount = 2;


    @Override
    public boolean retry(ITestResult result) {
        if(retryCount < maxRetryCount){
            logger.info("Retrying Class = " + result.getName());
            logger.info("Status of Class  = " + getResultsStatus(result.getStatus()) + " for the " + (retryCount +1) + " times.");
            retryCount++;
            return true;
       }
        return false;
    }

    public String getResultsStatus(int status){
        String resultName = null;
             switch (status){
                 case 1:
                     resultName = "SUCCESS";
                     break;
                 case 2:
                     resultName = "FAILURE";
                     break;
                 case 3:
                     resultName = "SKIP";
             }
             return resultName;
    }
}
