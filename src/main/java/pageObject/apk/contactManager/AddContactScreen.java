package pageObject.apk.contactManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class AddContactScreen extends BaseScreen {

    private WebElement contactNameEdit() {
        return driver().findElement(By.id(PATH + "contactNameEditText"));
    }

    private WebElement contactPhoneEdit() {
        return driver().findElement(By.id(PATH + "contactPhoneEditText"));
    }

    public void checkContactNameEdit() {
        assertTrue(contactNameEdit().isDisplayed());
    }

    public void checkContactPhoneEdit() {
        assertTrue(contactPhoneEdit().isDisplayed());
    }
}
