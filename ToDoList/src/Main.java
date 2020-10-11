import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        TheInterface user = new TheInterface(list, scanner);
        user.welcome();
        user.start();



    }
}