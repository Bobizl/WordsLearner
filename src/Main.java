import java.io.IOException;
import java.util.Scanner;


    class Main {
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (true) {
                System.out.print("1. Input a user\n" + "2. Input words and their meanings\n" +
                        "3. See what words you have in your Dictionary\n" +
                        "4. Play the game\n" +
                        "5. Delete the rang list\n" +
                        "6. Exit the program\n");
                System.out.print("Choose your option: ");
                if (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                } else {
                    break;
                }
                if (input.equals("6")) {
                    System.out.println(" The program is shutting down ");
                    break;
                }
                switch (input) {
                    case "1":
                        System.out.println("Input a user");
                        UsersInput.inputUser();
                        System.out.println();
                        break;

                    case "2":
                        System.out.println("Input words and their meanings");
                        WriteInFile.writeToFile();
                        System.out.println();
                        break;

                    case "3":
                        System.out.println("See the words you have in your Dictionary");
                        ReadFile n = new ReadFile();
                        n.readFromFile();
                        System.out.println();
                        break;

                    case "4":
                        System.out.println("Play the game");
                        QuizGame.shuffle();
                        System.out.println();
                        break;

                    case "5":
                        System.out.println("Reset the rang list");
                        ResetUserId.deleteAll();
                        ResetUserId.reset();
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        System.out.println();
                        break;
                }
            }
            scanner.close();
        }
    }


