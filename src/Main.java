import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
     WriteInFile n = new WriteInFile();
    n.writeToFile();
    QuizGame quiz = new QuizGame();
    quiz.shuffle();
        try {
            ReadFile q = new ReadFile();
            q.readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}