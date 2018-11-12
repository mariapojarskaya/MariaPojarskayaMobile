package setup.ex3.enums;


public enum Exceptions {
    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNCLEAR_TYPE("Unclear type of mobile app"), WRONG_NAME("Wrong name");
    public final String message;

    Exceptions(String message) {
        this.message = message;
    }
}
