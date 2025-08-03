package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(ConfigReader.get("db.driver")); // Load driver
        } catch (ClassNotFoundException e) {
            System.out.println("❌ PostgreSQL Driver not found!");
            e.printStackTrace();
        }

        String url = ConfigReader.get("db.url");
        String username = ConfigReader.get("db.username");
        String password = ConfigReader.get("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
