import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriteInFile {
    public static void writeToFile(){
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
        }while(!success);

        for (int i = 0; i < numPairs; i++) {
            System.out.print("Enter the [" + (i+1) + "] word in english: " );
            String key = scanner.nextLine();
            System.out.print("Enter the translation of word number [" + (i+1) + "] in bulgarian: " );
            String value = scanner.nextLine();

            inputHashMap.put(key, value);
        }

        String filePath = "Dictionary.txt";

        try {
            writeHashMapToFile(inputHashMap, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHashMapToFile(HashMap<String, String> inputHashMap, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));

        for (Map.Entry<String, String> entry : inputHashMap.entrySet()) {
            writer.write(entry.getKey() + " - " + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }
}
