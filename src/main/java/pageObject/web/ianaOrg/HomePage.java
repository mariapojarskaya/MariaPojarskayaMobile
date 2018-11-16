package pageObject.web.ianaOrg;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;
import static enums.IanaOrgConstants.*;

public class HomePage {

    protected final AppiumDriver driver;

    @FindBy (css = "h2 > a[href='/domains']")
    private WebElement domainsNamesLink;
    @FindBy (css = "h2 > a[href='/numbers']")
    private WebElement numberResourcesLink;
    @FindBy (css = "h2 > a[href='/protocols']")
    private WebElement protocolAssigmentLink;
    @FindBy (css = "#intro p")
    private WebElement introText;
    @FindBy (css = "#intro a")
    private WebElement introLearnMoreLink;


    public HomePage(AppiumDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void closeBrowser() {
        driver.closeApp();
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), TITLE.text);
    }

    public void checkIntro() {
        assertEquals(introText.getText(), INTRO.text);
        assertEquals(introLearnMoreLink.getAttribute("href"), LEARN_MORE_LINK.text);
    }

    public void checkHeadingLinksInPanels() {
        assertEquals(domainsNamesLink.getText(), DOMAIN_NAMES.text);
        assertEquals(numberResourcesLink.getText(), NUMBER_RESOURCES.text);
        assertEquals(protocolAssigmentLink.getText(), PROTOCOL_ASSIGNMENTS.text);
    }
}
