package scenarios.ex3.webtest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.web.ianaOrg.HomePage;
import setup.Driver;

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
