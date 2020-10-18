import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //ArrayList<ToDoList> toDoList = new ArrayList<>();

        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UserInterface user = new UserInterface(list, scanner);
        list.readAsData();
        user.welcome();
        user.startProcess();





    }
}
