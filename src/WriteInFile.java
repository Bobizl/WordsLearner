import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteInFile {
    public void writeToFile(String n) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        n = sc.nextLine();
       try {
           FileWriter fw = new FileWriter("E:\\Projects Ultimate\\WordLearner\\Words.txt");
       }catch (Throwable e){

       }
    }

}
