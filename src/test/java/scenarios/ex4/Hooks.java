package scenarios.ex4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static enums.PropertiesFiles.NATIVE;
import static enums.PropertiesFiles.WEB;

@Test
public class Hooks extends Driver {

    private static Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeSuite(groups = "native", description = "Prepare driver to run native test(s)")
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE.name);
        logger.info("Driver prepared");
    }

    @BeforeSuite(groups = "web", description = "Prepare driver to run web test(s)")
    public void setUpWeb() throws Exception {
        prepareDriver(WEB.name);
        logger.info("Driver prepared");
    }

    @AfterSuite(groups = {"web", "native"}, description = "Close driver on all tests completion")
    public void tearDown() {
        driver().quit();
        logger.info("Driver closed");
    }
}
