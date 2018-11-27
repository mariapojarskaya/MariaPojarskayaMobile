package scenarios.ex2;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected AndroidDriver driver;
    private String deviceName = "j5y17lte";
    private String emulator = "emulator-5555";

    protected void prepareAndroidNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Capabilities
        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("deviceName", emulator);
        capabilities.setCapability("platformName", "Android");

        //Path to app
        File app = new File("/src/main/resources/contactmanager.apk");
        capabilities.setCapability("app", app.getAbsolutePath());

        //Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Capabilities
        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("deviceName", emulator);
        capabilities.setCapability("platformName", "Android");

        //Specific web capabilities
        capabilities.setCapability("browserName", "Chrome");

        //Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
    }
}