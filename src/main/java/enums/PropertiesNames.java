package enums;

public enum PropertiesNames {
    AUT("aut"), SUT("sut"), PLATFORM("platform"), DRIVER("driver"), DEVICE("device");

    public String name;

    PropertiesNames(String title) {
        this.name = title;
    }
}