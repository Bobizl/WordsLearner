import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuizGame {
    public static void shuffle() {
        HashMap<String, String> dictionary = loadDictionaryFromFile("Dictionary.txt");
        List<String> shuffledKeys = shuffleKeys(dictionary);
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (String key : shuffledKeys) {
            displayMeaning(dictionary, key);
            String userAnswer = getUserAnswer(scanner);
            int lastInsertedUserId = getLastInsertedUserId();

            if (userAnswer.equals(key)) {
                updateScore(lastInsertedUserId, ++score);
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct word is: " + key);
            }

            displayPlayerInfo(lastInsertedUserId, score, dictionary.size());
        }

        scanner.close();
    }

    private static HashMap<String, String> loadDictionaryFromFile(String fileName) {
        HashMap<String, String> dictionary = new HashMap<>();
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
        return dictionary;
    }

    private static List<String> shuffleKeys(HashMap<String, String> dictionary) {
        List<String> shuffledKeys = new ArrayList<>(dictionary.keySet());
        Collections.shuffle(shuffledKeys);
        return shuffledKeys;
    }

    private static void displayMeaning(HashMap<String, String> dictionary, String key) {
        System.out.println("What is the word for the following meaning?");
        System.out.println(dictionary.get(key));
    }

    private static String getUserAnswer(Scanner scanner) {
        return scanner.nextLine().toLowerCase();
    }


}