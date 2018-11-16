package setup;

import enums.PropertiesNames;
import exceptions.UnclearAppTypeException;
import exceptions.UnknownPatformException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static io.appium.java_client.remote.MobileBrowserType.CHROME;
import static io.appium.java_client.remote.MobileBrowserType.SAFARI;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

/**
 * Initialize a driver with test properties
 */
public class Driver {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;
    private TestProperties properties;

    // PropertiesNames to be read
    protected static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver(String propertiesFileName) throws Exception {
        // Set properties
        properties = new TestProperties(propertiesFileName);
        AUT = properties.getProp(PropertiesNames.AUT.name);
        SUT = properties.getProp(PropertiesNames.SUT.name);
        TEST_PLATFORM = properties.getProp(PropertiesNames.PLATFORM.name);
        DRIVER = properties.getProp(PropertiesNames.DRIVER.name);
        DEVICE = properties.getProp(PropertiesNames.DEVICE.name);

        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case ANDROID:
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE); // default Android emulator
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                break;
            default:
                throw new UnknownPatformException();
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, webTests (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new UnclearAppTypeException();
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() {
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}

