import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private ToDoList theList;
    private Scanner scanner;

    public UserInterface(ToDoList constructorList, Scanner scanner) {
        this.theList = constructorList;
        this.scanner = scanner;


    }

    void welcome() {
        System.out.println(">> Welcome to To Do List");


    }

    void ListMenuItems() {

        System.out.println(">> You have " + theList.getSize() + " tasks to do " +
                "and " + theList.getExListSize() + " tasks are done");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add new task");
        System.out.println(">> (3) Edit Task");
        System.out.println(">> (4) Quit without saving");
        System.out.println(">> (5) Save and Quit \n");
        System.out.print(">> Pick an option:");
    }

    public void ListActiveTasks() {
        System.out.println("Press (p) to Sort Tasks by Subject \n" +
                           "Press (d) to Sort Tasks by Date");

        String in = scanner.nextLine();

        if(in.equals("p") || in.equals("P") ) {
            theList.sortByProject(theList.lists);

        } else if (in.equals("d") || in.equals("D") ) {
            theList.sortByDate(theList.lists);

        } else {
            System.out.println("Not a legal choice");
        }


        System.out.println("**************************");
    }

    void AddNewTask() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.print("\nPlease write the Task subject:");
        String subject = scanner.nextLine();

        System.out.print("Please write the Task title:");
        String title = scanner.nextLine();

        System.out.print("Please write the status of Task:");
        String status = scanner.nextLine();

        System.out.print("Please write the date in YYYY-MM-DD format:");
        String date = scanner.nextLine();

        ToDoList newTask = new ToDoList(subject, title, status, date);

        theList.addItem(newTask);


        System.out.println("*********** "+ ANSI_BLUE + newTask.title + ANSI_RESET +" added to the list  ***************");
        System.out.println("Press (Enter) to continue");


    }

    void EditTask() {
        System.out.println("Choose which task to edit");
        theList.print();
        System.out.println();
        int removal = scanner.nextInt();

        theList.remove(removal);

        System.out.println("************ Task removed ************** ");
    }

     void SaveAndQuit() {

        ToDoList todolist = new ToDoList();

        todolist.writeAsObject(theList.lists);
        System.out.println("Saved and Quit");

    }

    void QuitWithoutSave() {

        System.out.println("Quit");
    }

    void startProcess() throws IOException {

        while (1 == 1) {

            ListMenuItems();
//Get user's choice

              int in = scanner.nextInt();
              scanner.nextLine(); // to clean the scanner

            //Display the title of the chosen module
            if (in == 1)
                ListActiveTasks();
            else if (in == 2)
                AddNewTask();
            else if (in == 3)
                EditTask();
            else if (in == 4) {
                QuitWithoutSave();
                break;
            } else if (in == 5) {
                SaveAndQuit();
                break;
            }  else
                System.out.println("Please choose a valid option. Press (Enter)");
                System.in.read(); // requires (Enter) to restart, in case of an invalid option

        }
    }
}