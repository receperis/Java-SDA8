import java.util.Scanner;

public class UserInterface {
    private ToDoList classTypeList;
    //private ArrayList<ToDoList> toDoList;
    private Scanner scanner;

    public UserInterface(ToDoList constructorList, Scanner scanner) {
        this.classTypeList = constructorList;
        this.scanner = scanner;


    }

    void welcome() {
        System.out.println(">> Welcome to To Do List");


    }

    void ListMenuItems() {

        //toDoList.readAsData();

        System.out.println(">> You have " + classTypeList.getSize() + " tasks to do " +
                "and " + classTypeList.getExListSize() + " tasks are done");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add new task");
        System.out.println(">> (3) Edit Task");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> (5) Quit without saving");
        System.out.println(">> Pick an option:");
    }

    void ListActiveTasks() {
        System.out.println("List of active tasks");
        classTypeList.print();
        System.out.println("**************************");
    }

    void AddNewTask() {
        System.out.println("Please write the subject:");
        String subject = scanner.nextLine();

        System.out.println("Please write the title:");
        String title = scanner.nextLine();

        System.out.println("Please write the date in YYYY-MM-DD format:");
        String date = scanner.nextLine();

        ToDoList newTask = new ToDoList(subject, title, date);

        classTypeList.addItem(newTask.toString());


        System.out.println(newTask + " added to the list");
        System.out.println("**************************");

    }

    void EditTask() {
        System.out.println("Choose which task to remove");
        classTypeList.print();
        int removal = scanner.nextInt();
        classTypeList.remove(removal);
        System.out.println("Task removed");
        System.out.println("************************** \n\n");
    }

     void SaveAndQuit() {
        //ArrayList <ToDoList> list = new ArrayList<>();
        ToDoList todolist = new ToDoList();
        todolist.writeAsData(classTypeList.lists);
        System.out.println("Saved and Quit");

    }

    void QuitWithoutSave() {

        System.out.println("Quit");
    }

    void startProcess() {



        while (1 == 1) {

            ListMenuItems();
//Get user's choice
            int x = 1;
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
                SaveAndQuit();
                break;
            } else if (in == 5) {
                QuitWithoutSave();
                break;
            } else
                System.out.println("Please choose a valid option");

        }
    }
}