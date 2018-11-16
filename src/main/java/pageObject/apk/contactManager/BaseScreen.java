package pageObject.apk.contactManager;

import setup.Driver;

public class BaseScreen extends Driver {
    static final String PATH = "com.example.android.contactmanager:id/";

    public void closeApp() {
        driver().closeApp();
    }

    public void checkKeyboard() {
        driver().getKeyboard();
    }
}
