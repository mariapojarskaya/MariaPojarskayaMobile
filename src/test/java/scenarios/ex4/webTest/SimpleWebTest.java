package scenarios.ex4.webTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.web.ianaOrg.HomePage;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTest extends Driver {

    private HomePage homePage;
    protected SimpleWebTest() throws IOException {
        super();
    }
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
