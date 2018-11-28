package scenarios.ex4.webTest;

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


    @Test
    public void checkPageContent() {
        homePage.checkTitle();
        homePage.checkIntro();
        homePage.checkHeadingLinksInPanels();
    }
}
