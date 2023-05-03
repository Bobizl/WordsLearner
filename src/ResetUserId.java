import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetUserId {
    public static void reset() {
        String url = "jdbc:mysql://localhost:3306/competitors";
        String user = "root";
        String password = "123456";
        String resetUserIdQuery = "ALTER TABLE player AUTO_INCREMENT = 1;";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(resetUserIdQuery)) {
            statement.executeUpdate();
            System.out.println("user_id has been reset to start from 1.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
