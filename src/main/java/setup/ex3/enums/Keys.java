package setup.ex3.enums;


public enum Keys {
    TYPE("type"),
    AUT("aut"),
    T_SUT("sut"),
    TEST_PLATFORM("platform"),
    DRIVER("driver"),
    DEVICE("device"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity");;

    public final String key;

    Keys(String key) {
        this.key = key;
    }
}
