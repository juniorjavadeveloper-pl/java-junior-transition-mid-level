package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.value_properties;

import java.io.IOException;
import java.util.Properties;

public class JdbcPropertiesHelper {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(ClassLoader.getSystemClassLoader()
                    .getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
