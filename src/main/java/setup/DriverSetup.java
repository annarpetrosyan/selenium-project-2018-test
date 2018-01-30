//package setup;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class DriverSetup {
//    private static WebDriver driver;
//    public static String BROWSER =
//            System.getProperty("selenium.browser", "chrome");
//    //changes starts
//    private static ThreadLocal<WebDriver> driverThread;
//    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
//    // Changed ends
//
//    //updates
//    public static WebDriver initDriver() {
//        if (driver == null) {
//            switch (BROWSER) {
//                case "chrome":
//                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
//                            "C:\\Windows\\chromedriver.exe");
//                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
//                    //changes starts
//                    if(Boolean.valueOf(System.getProperty("selenium.remote", "false"))){
//                        return initRemoteDriver(DesiredCapabilities.chrome());
//                    }else {
//                        driverThread = new ThreadLocal<WebDriver>(){
//                            @Override
//                            protected WebDriver initialValue(){
//                                WebDriver webDriver = null;
//                                webDriver = new ChromeDriver();
//                                webDriverPool.add(webDriver);
//                                return webDriver;
//                            }
//                        };
//                    }
////                    driver = new ChromeDriver();
////                    driver.manage().window().maximize();
//                    break;
//
//                case "firefox":
//                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
//                            "C:\\Windows\\chromedriver.exe");
//                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
//                    driver = new FirefoxDriver();
//                    driver.manage().window().maximize();
//                    break;
//                case "remoteDriver":
//                  try {
//                     driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new DesiredCapabilities());
//                     } catch (MalformedURLException e) {
//                       e.printStackTrace();
//                      }
//                    driver.manage().window().maximize();
//                    break;
//            }
//        }
//        return driver;
//    }
//
//    private static WebDriver initRemoteDriver(DesiredCapabilities capability) {
//        driverThread = new ThreadLocal<WebDriver>(){
//            @Override
//            protected WebDriver initialValue(){
//                WebDriver webDriver = null;
//                try{
//                    capability.setCapability(CapabilityType.BROWSER_NAME, "Linux");
//                    webDriver = new RemoteWebDriver(new URL(""), capability);
//                    webDriverPool.add(webDriver);
//                }catch (MalformedURLException e){
//                    e.printStackTrace();
//                }
//                return webDriver;
//            }
//        };
//        return null;
//    }
//
//    public static WebDriver getDriver(){
//        if(driverThread == null){
//            initDriver();
//        }
//        return driverThread.get();
//    }
//
//    public static void quitDriver() {
//        for (WebDriver webDriver : webDriverPool) {
//            if (webDriver != null) {
//                if (((RemoteWebDriver) webDriver).getSessionId() != null) {
//                    webDriver.close();
//                }
//                webDriver.quit();
//            }
//        }
//        driverThread = null;
//    }
//
//
////    public static void quitDriver() {
////        if (driver != null) {
////            if(BROWSER.equals("firefox")){
////                driver.close();
////                driver = null;
////            } else if (BROWSER.equals("chrome")) {
////                driver.close();
////                driver.quit();
////                driver = null;
////            }
////        }
////    }
//}
package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread;
    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());

    //    @BeforeTest
    public static WebDriver initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "C:\\Windows\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "false"))) {
                        return initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread = new ThreadLocal<WebDriver>() {
                            @Override
                            protected WebDriver initialValue() {
                                WebDriver webDriver = null;
                                webDriver = new ChromeDriver();
                                webDriverPool.add(webDriver);
                                return webDriver;
                            }
                        };
                    }
                    break;
                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "/Users/sargis/dev/selenium-drivers/geckodriver");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().fullscreen();
                    break;
            }
        }
        return driver;
    }

    public static WebDriver initRemoteDriver(DesiredCapabilities capability) {
        driverThread = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                WebDriver webDriver = null;
                try {
                    capability.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
                    webDriver = new RemoteWebDriver(new URL(""), capability);
                    webDriverPool.add(webDriver);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return webDriver;
            }
        };
        return null;
    }

    public static WebDriver getDriver() {
        if (driverThread == null){
            initDriver();
        }
        return driverThread.get();
    }


    public static void quitDriver() {
        webDriverPool.stream().filter(driver -> driver != null).forEach(driver -> {
            if (((RemoteWebDriver) driver).getSessionId() != null) {
                driver.close();
            }
            driver.quit();
        });
    }
}
