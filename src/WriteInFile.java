import java.io.*;
import java.sql.SQLOutput;
import java.util.Dictionary;
import java.util.Scanner;

public class WriteInFile {
    public void writeToFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the words you want to input in the dictionary = ");
        String outputFile = "Dictionary.txt";
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile,true))){
           String input;
           while(true){
               input = scanner.nextLine();
               if("exit".equalsIgnoreCase(input)){
                   break;
               }
               writer.write(input);
               writer.newLine();
           }
           System.out.println("Words saved to " + outputFile);
       }catch(IOException e){
           System.out.println("Something wrong happened !");
        }
    }
}
