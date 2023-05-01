import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersInput {
    public void inputUser(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your age: ");
        String userAge = scanner.nextLine();

        addPlayerToDatabase(userName, userAge);
    }
    private static void addPlayerToDatabase(String userName, String userAge) {
        String url = "jdbc:mysql://localhost:3306/competitors";
        String user = "root";
        String password = "123456";

        String insertPlayerQuery = "INSERT INTO player (User_name, User_age) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(insertPlayerQuery)) {

            statement.setString(1, userName);
            statement.setString(2, userAge);

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

