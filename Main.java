
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(list, scanner);
        list.readAsObject();
        user.welcome();



        while(1==1){ // To restart the code, in case user enters an invalid input.
            try {
                user.startProcess();
            } catch (Exception e) {
                System.out.println("\nInvalid Entry. " +
                                 "\nPress (Enter) to try again.");
                scanner.nextLine(); // to clean the scanner. Otherwise it could go into an infinite loop.

                System.in.read(); // requires (enter) to restart the process

                continue; // restarts the process
            }
        }

    }
}

