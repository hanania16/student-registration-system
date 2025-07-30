//	Reads DB connection info from config/db.properties.
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config/db.properties");
            props.load(fis);
        } catch (IOException e) {
            System.out.println("⚠️ Failed to read config file.");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}

