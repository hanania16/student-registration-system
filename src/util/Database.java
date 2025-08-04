// package util;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class Database {
//     public static Connection getConnection() {
//         try {
//             String driver = ConfigReader.get("org.postgresql.Driver");
//             String url = ConfigReader.get("jdbc:postgresql://localhost:5432/Student_RegistrationDB");
//             String username = ConfigReader.get("postgres");
//             String password = ConfigReader.get("1234567");

//             if (driver == null || url == null || username == null) {
//                 System.err.println("❌ Database configuration is missing or incomplete.");
//                 return null;
//             }

//             Class.forName(driver);
//             return DriverManager.getConnection(url, username, password);

//         } catch (ClassNotFoundException e) {
//             System.err.println("❌ Database driver not found.");
//             e.printStackTrace();
//         } catch (SQLException e) {
//             System.err.println("❌ Failed to connect to database.");
//             e.printStackTrace();
//         }
//         return null;
//     }
// }

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection() {
        try {
            // ✅ Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // ✅ Direct DB connection info
            String url = "jdbc:postgresql://localhost:5432/Student_RegistrationDB";
            String username = "postgres";
            String password = "1234567";

            return DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Database driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database.");
            e.printStackTrace();
        }
        return null;
    }
}
