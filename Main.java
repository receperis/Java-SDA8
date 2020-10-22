
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(list, scanner);
        list.readAsObject();
        user.welcome();



        while(user.exit == 1){ // While loop in order to restart the code.
                                // While loop breaks when exit++ in SaveandQuit() or QuitWithoutSave() methods.
            try {
                user.startProcess();
            } catch (Exception e) {
                System.out.println("\nInvalid Entry. " +
                                 "\nPress (Enter) to try again.");
                scanner.nextLine(); // to clean the scanner. Otherwise it could go into an infinite loop.
                System.in.read(); // requires (Enter) to restart the process

                continue; // restarts the loop

            }
        }

    }
}

