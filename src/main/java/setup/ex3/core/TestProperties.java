package setup.ex3.core;

import setup.ex3.enums.Exceptions;
import setup.ex3.enums.PropertyFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static setup.ex3.enums.Keys.TYPE;
import static setup.ex3.enums.PropertyFiles.*;


public class TestProperties {
    private Properties currentProps = new Properties();
    private final static String testProperties = COMMON.path;

    private Properties getCurrentProps() throws IOException {
        currentProps.load(TestProperties.class.getClassLoader().getResourceAsStream(testProperties));
        String fileName;
        switch (PropertyFiles.valueOf(currentProps.getProperty(TYPE.key).toUpperCase())) {
            case WEB: {
                fileName = WEB.path;
                break;
            }
            case NATIVE: {
                fileName = NATIVE.path;
                break;
            }
            default: {
                throw new IllegalArgumentException(Exceptions.WRONG_NAME.message);
            }
        }
        FileInputStream in = new FileInputStream(fileName);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);

    }
}
