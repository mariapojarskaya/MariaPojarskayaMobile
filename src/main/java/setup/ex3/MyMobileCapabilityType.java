package setup.ex3;

import org.openqa.selenium.remote.CapabilityType;


public interface MyMobileCapabilityType extends CapabilityType {

    String APP_PACKAGE = "appPackage";

    String APP_ACTIVITY = "appActivity";
}
