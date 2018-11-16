package pageObject.apk.contactManager;

import io.appium.java_client.MobileElement;

import static org.testng.Assert.assertTrue;

public class HomeScreen extends BaseScreen {

    private MobileElement addContactButton() {
        return (MobileElement) driver().findElementByAccessibilityId( "Add Contact");
    }

    public void addContactButtonClick() {
        addContactButton().click();
    }

    public void checkAddContactButton() {
        assertTrue(addContactButton().isDisplayed());
    }
}
