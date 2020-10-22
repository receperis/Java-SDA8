import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(list, scanner);
        list.readAsObject();
        user.welcome();
        user.startProcess();

    }
}
