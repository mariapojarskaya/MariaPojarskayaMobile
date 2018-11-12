package scenarios.ex3.nativeTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.ex3.contactmanager.po.AddContactPage;
import setup.ex3.contactmanager.po.ContactManagerPage;
import setup.ex3.core.Driver;

import java.io.IOException;



@Test(groups = "native")
public class SimpleNativeTest extends Driver {
    private ContactManagerPage contactManagerPage;
    private AddContactPage addContactPage;

    protected SimpleNativeTest() throws IOException {
        super();

    }

    @BeforeClass(alwaysRun = true)
    public void setUpPageObject() throws Exception {
        contactManagerPage = new ContactManagerPage(driver());
        addContactPage = new AddContactPage(driver());

    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() {

        contactManagerPage.add_btnClick();
        // Check if Name Field is displayed
        addContactPage.checkIfNameFieldIsDisplayed();
        //Check if Title is displayed And above the field
        addContactPage.checkIfTitleIsDisPlayedAndAbove();
        //Send keys ro Name Field and check he result
        addContactPage.sendKeysToNameField("Mark");
        System.out.println("Simplest Appium test done");

    }
}

