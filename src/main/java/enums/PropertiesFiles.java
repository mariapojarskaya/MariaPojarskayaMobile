package enums;

public enum PropertiesFiles {
    NATIVE("nativetest.properties"), WEB("webtest.properties");

    public String name;

    PropertiesFiles(String name) {
        this.name = name;
    }
}
