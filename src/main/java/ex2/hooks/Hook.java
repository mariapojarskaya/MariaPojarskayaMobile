package hooks;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;

//@Test(groups = {"native","web"})
public class Hook extends Driver {
    Hook() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
    }
}
