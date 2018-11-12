package scenarios.ex2.webtest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.ex2.core.Driver;

import java.io.IOException;


@Test(groups = "web")
public class SimpleWebTest extends Driver {

    static {
        fileName = "src/main/resources/webtest.properties";
    }

    protected SimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        //check web Page title and url
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        driverWait().until(ExpectedConditions.titleIs("Internet Assigned Numbers Authority"));
        System.out.println("Site opening done");
    }

}


