import java.util.Scanner;
import Commands.*;
import Factories.CommandFactory;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command currentCommand = null;
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] inputArgs = input.split("\\s+");

            try {
                if (currentCommand == null) {
                    currentCommand = CommandFactory.createCommand(inputArgs);
                }

                if (currentCommand instanceof ExitCommand) {
                    exitProgram = true;
                }

                currentCommand.execute(inputArgs);
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                currentCommand = null;
            }
        }
        scanner.close();
    }
}