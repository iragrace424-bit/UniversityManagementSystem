import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/university_db";
            String username = "postgres";
            String password = "12345";

            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

}