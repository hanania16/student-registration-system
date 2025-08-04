package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream fis = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config/db.properties")) {

            if (fis != null) {
                properties.load(fis);
            } else {
                System.err.println("❌ Could not find 'config/db.properties' in classpath.");
            }
        } catch (IOException e) {
            System.err.println("❌ Failed to load database config file.");
            e.printStackTrace();

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

        return properties.getProperty(key);

        return props.getProperty(key);

    }
}

