package scenarios.ex4.webTest;

import pageObject.web.ianaOrg.HomePage;
import setup.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "web")
public class SimpleWebTest extends Driver {

    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver().get(SUT);
        homePage = new HomePage(driver());
    }

    @AfterClass
    public void afterClass() {
        homePage.closeBrowser();
    }

    @Test
    public void checkPageContent() {
        homePage.checkTitle();
        homePage.checkIntro();
        homePage.checkHeadingLinksInPanels();
    }
}
