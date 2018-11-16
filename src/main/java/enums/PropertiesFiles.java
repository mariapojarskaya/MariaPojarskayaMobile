package enums;

public enum PropertiesFiles {
    NATIVE("nativetests.properties"), WEB("webtests.properties");

    public String name;

    PropertiesFiles(String name) {
        this.name = name;
    }
}
