import java.io.*;

public class ReadFile {


    public void readFromFile() throws IOException {
        File file = new File("E:\\Projects Ultimate\\WordLearner\\WordsInput\\Dictionary.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String string;
        while((string = reader.readLine()) != null){
            System.out.println(string);
        }

    }
}
