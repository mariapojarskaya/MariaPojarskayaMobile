package scenarios.ex2.nativeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.ex2.core.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


@Test(groups = "native")
public class SimpleNativeTest extends Driver {
    static {
        fileName = "src/main/resources/nativetest.properties";
    }

    protected SimpleNativeTest() throws IOException {
        super();

    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        //com.example.android.contactmanager:id/contactNameEditText
        driver().findElement(add_btn).click();
        // Check if Name Field is displayed
        By nameField = By.id(app_package_name + "contactNameEditText");
        Assert.assertTrue(driver().findElement(nameField).isDisplayed());

        //Check if Title is displayed And above the field
        By nameFieldTitle = By.id("Contact Name");

        Assert.assertTrue(driver().findElement(nameFieldTitle).getLocation().getY() <
                driver().findElement(nameField).getLocation().getY());

        //Send keys ro Name Field and check he result
        driver().findElement(nameField).sendKeys("Mark");
        Assert.assertEquals(driver().findElement(nameField).getText(), "Mark");

        //Check if keyboard is present
        String cmd[] = new String[]{"adb", "shell", "dumpsys", "input_method"};
        Process process = Runtime.getRuntime().exec(cmd);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        List<String> cdmLines = reader.lines().filter(line -> line.matches(".*mInputShown.*")).collect(Collectors.toList());

        Assert.assertTrue(cdmLines.get(0).endsWith("true"));

        System.out.println("Simplest Appium test done");

    }
}

