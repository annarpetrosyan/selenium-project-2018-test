package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver",
                            "C:\\Windows\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "false"))) {
                        initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread.set(new ChromeDriver());
                    }
                    break;
                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "C:\\Windows\\geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "true"))) {
                        initRemoteDriver(DesiredCapabilities.firefox());
                    } else {
                        driverThread.set(new FirefoxDriver());
                    }
                    break;
            }
        }
    }

    public static void initRemoteDriver(DesiredCapabilities capability) {
        capability.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://annarpetrosyan:80a0c3b4-e8e8-4ba3-9a14-1745d3248943@ondemand.saucelabs.com:80/wd/hub"), capability); //TODO Question
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverThread.set(webDriver);
    }

    public static WebDriver getDriver() {
            return driverThread.get();
    }


    public static void quitDriver() {
        getDriver().close();
        getDriver().quit();

    }
}