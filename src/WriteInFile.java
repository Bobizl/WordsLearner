import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WriteInFile {
    public static void writeToFile(){
        HashMap<String, String> inputHashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int numPairs = 1;//it can work without the try catch block
        System.out.print("Enter the number of key-value pairs: ");
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
            System.out.println("Enter key " + (i + 1) + ":");
            String key = scanner.nextLine();
            System.out.println("Enter value " + (i + 1) + ":");
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
