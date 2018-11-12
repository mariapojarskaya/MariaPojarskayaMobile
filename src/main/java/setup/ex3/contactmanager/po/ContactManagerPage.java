package setup.ex3.contactmanager.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ContactManagerPage {

    private final String app_package_name = "com.example.android.contactmanager:id/";
    @AndroidFindBy(id = app_package_name + "addContactButton")
    private AndroidElement add_btn;

    public ContactManagerPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                        Duration.ZERO),
                this
        );
    }

    public void add_btnClick() {
        add_btn.click();
    }

}
