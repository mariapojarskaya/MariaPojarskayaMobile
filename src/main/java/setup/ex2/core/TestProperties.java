package setup.ex2.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    protected Properties currentProps = new Properties();
    protected static String fileName;
    private final static String testProperties = "test.properties";

    protected Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        currentProps.load(in);
        Properties testProps = new Properties();
        testProps.load(TestProperties.class.getClassLoader().getResourceAsStream(testProperties));
        in.close();
        currentProps.putAll(testProps);

        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);

    }

}
