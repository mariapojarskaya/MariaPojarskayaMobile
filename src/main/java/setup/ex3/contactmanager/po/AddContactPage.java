package setup.ex3.contactmanager.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class AddContactPage {
    private final String app_package_name = "com.example.android.contactmanager:id/";
    @AndroidFindBy(id = app_package_name + "contactNameEditText")
    private AndroidElement nameField;
    @AndroidFindBy(id = "Contact Name")
    private AndroidElement nameFieldTitle;

    public AddContactPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                        Duration.ZERO),
                this
        );
    }


    public void checkIfNameFieldIsDisplayed() {
        Assert.assertTrue(nameField.isDisplayed());
    }

    //DOES NOT WORK
    public boolean keyboardIsOpened() throws Exception {
        try {
            String cmd[] = new String[]{"adb", "shell", "dumpsys", "input_method"};
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            List<String> cdmLines = reader.lines().filter(line -> line.matches(".*mInputShown.*")).collect(Collectors.toList());
            return cdmLines.get(0).endsWith("true");
        } catch (IOException e) {
            throw new Exception("dfghj");
        }

    }

    public void checkIfTitleIsDisPlayedAndAbove() {
        Assert.assertTrue(nameFieldTitle.isDisplayed());
        Assert.assertTrue(nameFieldTitle.getLocation().getY() < nameField.getLocation().getY());
    }

    public void sendKeysToNameField(String name) {
        nameField.sendKeys(name);
        Assert.assertEquals(nameField.getText(), name);
    }
}
