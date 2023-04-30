import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersInput {
    public void inputUser(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your age: ");
        String userAge = scanner.nextLine();

        System.out.print("Enter your points: ");
        String userPoints = scanner.nextLine();

        addPlayerToDatabase(userId, userName, userAge, userPoints);
    }
    private static void addPlayerToDatabase(int userId, String userName, String userAge, String userPoints) {
        String url = "jdbc:mysql://localhost:3306/competitors";
        String user = "root";
        String password = "123456";

        String insertPlayerQuery = "INSERT INTO player (User_id, User_name, User_age, User_points) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(insertPlayerQuery)) {

            statement.setInt(1, userId);
            statement.setString(2, userName);
            statement.setString(3, userAge);
            statement.setString(4, userPoints);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Player added successfully!");
            } else {
                System.out.println("Failed to add player.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

