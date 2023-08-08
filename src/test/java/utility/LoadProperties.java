package utility;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	@Getter
    private static Properties runProps;

  

    public static void loadRunConfigProps(String configPropertyFileLocation) {
        runProps = new Properties();
        try (InputStream inputStream = LoadProperties.class.getResourceAsStream(configPropertyFileLocation)) {
            runProps.load(inputStream);
            setUpEnvironmentURLFor("webUrl");
            setUpEnvironmentURLFor("pilApiBaseUrl");
            setUpEnvironmentURLFor("platform");
            setUpEnvironmentURLFor("browser");
            setUpEnvironmentURLFor("device");
            setUpEnvironmentURLFor("deviceName");
            setUpEnvironmentURLFor("driver.root.dir");
            setUpEnvironmentURLFor("environment");
            setUpEnvironmentURLFor("planId");
            setUpEnvironmentURLFor("suiteId");
            setUpEnvironmentURLFor("team");
            setUpEnvironmentURLFor("sprint");
        } catch (IOException e) {
            
        }
    }

    protected static void setUpEnvironmentURLFor(String key) {
        String value = getRunProps().getProperty(key);
        System.out.println("Properties : key " + key + " | value: " + value);
        if (null == value) {
        	 System.out.println(String.format("property %s has null value injected", value));
        } else if (value == "") {
        	 System.out.println(String.format("property %s has empty string value injected", value));
        }
        if (StringUtils.startsWith(value, "http://")) {
            return;
        }
        String urlFromVMOptions = System.getProperty(key);
        if (null != urlFromVMOptions) {
            LoadProperties.getRunProps().put(key, urlFromVMOptions);
        }
    }
}
