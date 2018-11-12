package ex3.pages.enums;

public enum Properties {
    COMMON("test.properties"),
    WEB("src/main/resources/webtest.properties"),
    NATIVE("src/main/resources/nativetest.properties");
    public final String path;

    Properties(String path) {
        this.path = path;
    }
}
