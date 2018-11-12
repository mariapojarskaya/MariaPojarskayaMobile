package setup.ex3.site.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class IANAHomePage {
    private String url;
    private static final String TITLE = "Internet Assigned Numbers Authority";
    private AppiumDriver driver;
    private WebDriverWait webDriverWait;
    @FindBy(css = "#home-panels > div")
    private List<RemoteWebElement> homePanels;
    @FindBy(css = "#gs_tti50 input")
    private RemoteWebElement searchInput;
    @FindBy(css = ".gsc-search-button button")
    private RemoteWebElement searchButton;

    public IANAHomePage(AppiumDriver driver, String url, WebDriverWait webDriverWait) {
        this.url = url;
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                        Duration.ZERO),
                this);

    }

    public void checkMainContent() {
        //TODO try to make it work
        //webDriverWait.until(ExpectedConditions.visibilityOfAllElements(homePanels));
        for (RemoteWebElement panel : homePanels) {
            panel.isDisplayed();
        }
        Assert.assertEquals(homePanels.size(), 3);

    }

    public void open() {
        driver.get(url);
    }

    public void checkUrl() {
        webDriverWait.until(ExpectedConditions.urlToBe(url + "/"));
    }

    public void checkTitle() {
        webDriverWait.until(ExpectedConditions.titleIs(TITLE));
    }

    public void searchForInfo(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }
}
