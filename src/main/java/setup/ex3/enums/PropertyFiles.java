package setup.ex3.enums;


public enum PropertyFiles {
    COMMON("test.properties"),
    WEB("src/main/resources/webtest.properties"),
    NATIVE("src/main/resources/nativetest.properties");
    public final String path;

    PropertyFiles(String path) {
        this.path = path;
    }
}
