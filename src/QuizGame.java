import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuizGame {
    public static void shuffle() {

        HashMap<String, String> dictionary = new HashMap<>();
        String fileName = "Dictionary.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-", 2);
                if (parts.length == 2) {
                    dictionary.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        List<String> shuffledKeys = new ArrayList<>(dictionary.keySet());
        Collections.shuffle(shuffledKeys);

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (String key : shuffledKeys) {
            System.out.println("What is the word for the following meaning?");
            System.out.println(dictionary.get(key));
            String userAnswer = scanner.nextLine().toLowerCase();

            if (userAnswer.equals(key)) {
                System.out.println("Correct!");
                score++;
                String url = "jdbc:mysql://localhost:3306/competitors";
                String user = "root";
                String password = "123456";
                String insertPointsQuery = String.format("UPDATE player SET User_points=%da WHERE User_id=1", score);
                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement statement = connection.prepareStatement(insertPointsQuery)) {
                     statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Incorrect. The correct word is: " + key);

            }
        }
        System.out.println("Your score: " + score + "/" + dictionary.size());
        scanner.close();
    }
}