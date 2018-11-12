package setup.ex3.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.ex3.MyMobileCapabilityType;
import setup.ex3.enums.Keys;
import setup.ex3.enums.Platform;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobileBrowserType.CHROME;
import static io.appium.java_client.remote.MobileBrowserType.SAFARI;
import static setup.ex3.enums.Exceptions.UNCLEAR_TYPE;
import static setup.ex3.enums.Exceptions.UNKNOWN_PLATFORM;


public class Driver extends TestProperties {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;


    // PropertyFiles to be read
    protected String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    protected String TEST_PLATFORM;
    protected String DRIVER;
    protected String DEVICE;
    protected String DEVICE_NAME;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;


    // Constructor initializes properties on driver creation
    protected Driver() throws IOException {
        AUT = getProp(Keys.AUT.key);
        String t_sut = getProp(Keys.T_SUT.key);
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp(Keys.TEST_PLATFORM.key);
        DRIVER = getProp(Keys.DRIVER.key);
        DEVICE = getProp(Keys.DEVICE.key);
        DEVICE_NAME = getProp(Keys.DEVICE_NAME.key);
        UDID = getProp(Keys.UDID.key);
        APP_PACKAGE = getProp(Keys.APP_PACKAGE.key);
        APP_ACTIVITY = getProp(Keys.APP_ACTIVITY.key);
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);

        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

            capabilities.setCapability(MyMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
            capabilities.setCapability(MyMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        } else if (SUT != null && AUT == null) {
            // Web
            // Setup test platform: Android or iOS. Browser also depends on a platform.
            switch (Platform.valueOf(TEST_PLATFORM.toUpperCase())) {
                case ANDROID:
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, CHROME);
                    break;
                case IOS:
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, SAFARI);
                    break;
            }
        } else {
            throw new Exception(UNCLEAR_TYPE.message);
        }

        // Init driver for local Appium server with capabilities have been set
        switch (Platform.valueOf(TEST_PLATFORM.toUpperCase())) {
            case ANDROID:
                driverSingle = new AndroidDriver(new URL(DRIVER), capabilities);
                break;
            case IOS:
                driverSingle = new IOSDriver(new URL(DRIVER), capabilities);
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.message);
        }

        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 20);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingle;
    }

}
