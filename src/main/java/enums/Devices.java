package enums;

public enum Devices {
    EMULATOR("emulator-5554"), PHILIPSW6610("PHILIPS Xenium W6610");

    public String name;

    Devices(String name) {
        this.name = name;
    }
}
