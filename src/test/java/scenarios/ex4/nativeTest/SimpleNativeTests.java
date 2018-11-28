package scenarios.ex4.nativeTest;

import org.testng.annotations.Test;
import pageObject.apk.contactManager.AddContactScreen;
import pageObject.apk.contactManager.BaseScreen;
import pageObject.apk.contactManager.HomeScreen;

@Test(groups = "native")
public class SimpleNativeTests {

    private BaseScreen baseScreen;
    private HomeScreen homeScreen;
    private AddContactScreen addContactScreen;

    @Test(description = "Check addContactButton is displayed")
    public void checkAddContactButtonTest() {
        homeScreen.checkAddContactButton();
    }

    @Test(description = "Check checkContactNameEdit and checkContactPhoneEdit is displayed")
    public void checkContactNameAndPhoneEditTest() {
        homeScreen.addContactButtonClick();
        addContactScreen.checkContactNameEdit();
        addContactScreen.checkContactPhoneEdit();
    }
}

