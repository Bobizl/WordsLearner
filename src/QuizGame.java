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


}