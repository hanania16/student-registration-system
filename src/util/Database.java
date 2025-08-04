package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName(ConfigReader.get("db.driver"));
            return DriverManager.getConnection(
                    ConfigReader.get("db.url"),
                    ConfigReader.get("db.username"),
                    ConfigReader.get("db.password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
