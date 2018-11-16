package scenarios.ex4.nativeTest;

import pageObject.apk.contactManager.AddContactScreen;
import pageObject.apk.contactManager.BaseScreen;
import pageObject.apk.contactManager.HomeScreen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "native")
public class SimpleNativeTests {

    private BaseScreen baseScreen;
    private HomeScreen homeScreen;
    private AddContactScreen addContactScreen;

    @BeforeClass
    public void beforeClass() {
        baseScreen = new BaseScreen();
        homeScreen = new HomeScreen();
        addContactScreen = new AddContactScreen();
    }

    @AfterClass
    public void afterClass() {
        baseScreen.closeApp();
    }

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

