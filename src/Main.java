import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner menu = new Scanner(System.in);
        String stopGame = "stop";

        System.out.print("1. Input a user\n" + "2. Input words and their meanings\n" +
                "3. See what words you have in yout Dictionary\n" +
                "4. Play the game\n");
        System.out.print("Choose your option ");
        int options;
        options = menu.nextInt();

        do {
            switch (options) {
                case 1:
                    System.out.println(" Input a user ");
                    UsersInput.inputUser();
                    break;
                case 2:
                    System.out.println(" Input words and their meanings ");
                    WriteInFile.writeToFile();
                    break;
                case 3:
                    System.out.println(" See the words you have in your Dictionary ");
                    ReadFile n = new ReadFile();
                    n.readFromFile();
                    break;
                case 4:
                    System.out.println(" Play the game ");
                    QuizGame.shuffle();
                    break;
            }
            while (options == 0) ;
        }while(false);
    }
}