import java.io.*;
import java.util.*;

public class WriteInFile {
    private static boolean isEnglish = true;

    public static void changeLanguage() {
        isEnglish = !isEnglish;
    }

    public static void writeToFile() {
        HashMap<String, String> inputHashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int numPairs = 1;
        System.out.print("Enter the number of the words you would like to learn: ");
        boolean success = false;
        do {
            try {
                numPairs = Integer.parseInt(scanner.nextLine());
                success = true;
            } catch (Exception e) {
                System.out.println("Wrong ! Try again ");
            }
        } while (!success);

        for (int i = 0; i < numPairs; i++) {
            System.out.print("Enter the [" + (i + 1) + "] word in " + (isEnglish ? "english" : "bulgarian") + ": ");
            String firstWord = scanner.nextLine();
            System.out.print("Enter the translation of word number [" + (i + 1) + "] in " + (isEnglish ? "bulgarian" : "english") + ": ");
            String secondWord = scanner.nextLine();

            if (isEnglish) {
                inputHashMap.put(firstWord, secondWord);
            } else {
                inputHashMap.put(secondWord, firstWord);
            }
        }

        String filePath = "Dictionary.txt";

        try {
            writeHashMapToFile(inputHashMap, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHashMapToFile(HashMap<String, String> inputHashMap, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

        for (Map.Entry<String, String> entry : inputHashMap.entrySet()) {
            writer.write(entry.getKey() + " - " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }
}







