package enums;

public enum IanaOrgConstants {
    TITLE("Internet Assigned Numbers Authority"),
    DOMAIN_NAMES("Domain Names"),
    NUMBER_RESOURCES("Number Resources"),
    PROTOCOL_ASSIGNMENTS("Protocol Assignments"),
    INTRO("The global coordination of the DNS Root, IP addressing, and other Internet protocol" +
            " resources is performed as the Internet Assigned Numbers Authority (IANA) functions. Learn more."),
    LEARN_MORE_LINK("https://www.iana.org/about/");

    public String text;

    IanaOrgConstants(String text) {
        this.text = text;
    }
}
