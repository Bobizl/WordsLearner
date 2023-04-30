import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersInput {
    public void inputUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        addUserToDatabase(name, age);
    }

    void addUserToDatabase(String name, int age) {
        String url = "jdbc:mysql://localhost:3306/player";
        String user = "root";
        String password = "123456";

        String insertUserQuery = "INSERT INTO users (name, age)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {

            statement.setString(1, name);
            statement.setInt(2, age);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

