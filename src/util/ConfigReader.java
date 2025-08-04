//	Reads DB connection info from config/db.properties.
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/config/db.properties");
            properties.load(fis);
        } catch (IOException e) {
            System.out.println(" Could not load database config file.");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
