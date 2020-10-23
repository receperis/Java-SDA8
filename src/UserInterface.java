import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private ToDoList toDo;
    private Scanner scanner;
    public int exit = 1; // Integer in order to break while loop in main method

    public UserInterface(ToDoList constructorList, Scanner scanner) {
        this.toDo = constructorList;
        this.scanner = scanner;


    }

    void welcome() {
        System.out.println(">> Welcome to To Do List");
    }

    void ListMenuItems() {

        // color codes
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        System.out.println(">> You have " + toDo.getSize() + " tasks to do " +
                "and " + toDo.getExListSize() + " tasks are done");
        System.out.println(ANSI_RED+">>" + ANSI_BLUE + " (1) " + ANSI_RESET + " Show Task List (by date or project)");
        System.out.println(ANSI_RED+">>" + ANSI_BLUE + " (2) " + ANSI_RESET + "Add new task");
        System.out.println(ANSI_RED+">>" + ANSI_BLUE + " (3) " + ANSI_RESET + "Edit Task");
        System.out.println(ANSI_RED+">>" + ANSI_BLUE + " (4) " + ANSI_RESET + "Quit without saving");
        System.out.println(ANSI_RED+">>" + ANSI_BLUE + " (5) " + ANSI_RESET + "Save and Quit \n");
        System.out.print(ANSI_RED+">> Pick an option:");
    }

    public void ListActiveTasks() {
        System.out.println("Press (P) to Sort Tasks by Subject \n" +
                            "Press (D) to Sort Tasks by Date");

        String in = scanner.nextLine();

        if (in.toLowerCase().equals("p")) { //accepts upper case or lower case inputs
            toDo.sortByProject(toDo.getActiveList());

        } else if (in.toLowerCase().equals("d")) {
            toDo.sortByDate(toDo.getActiveList());

        } else {
            System.out.println("Not a valid input");
            System.out.println("Press (Enter) to restart");
        }

    }

    void AddNewTask() throws IOException {
        //Color codes for the visual purposes
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

        Task newTask = new Task(subject, title, status, date);

        toDo.addItem(newTask);


        System.out.println("\n*********** added to the list  ***************");
        System.out.println("Press (Enter) to continue");
        System.in.read();


    }



    void EditTask() throws IOException {

        toDo.print();

        System.out.print("Choose a task number to edit :");

        int index = scanner.nextInt(); //index for the object in ArrayList
        scanner.nextLine(); // to clean the scanner

        System.out.println(">> (1) Update Project");
        System.out.println(">> (2) Update Title");
        System.out.println(">> (3) Update Date");
        System.out.println(">> (4) Update Status");
        System.out.println(">> (5) Remove/Cancel \n");

        System.out.print("Pick an edit option :");

        int in = scanner.nextInt(); //Get user's choice for edit
        scanner.nextLine(); // to clean the scanner


        //Display the title of the chosen module
        if (in == 1) {
            System.out.print("Enter new Project :");
            String newProject = scanner.nextLine();

            Task pickedList = toDo.pickList(index);
            pickedList.setProject(newProject);

        } else if (in == 2) {
            System.out.print("Enter new Title :");
            String newTitle = scanner.nextLine();

            Task pickedList = toDo.pickList(index);
            pickedList.setTitle(newTitle);

        } else if (in == 3) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.print("Enter new Date :");
            String scnDate = scanner.nextLine();

            LocalDate newDate = LocalDate.parse(scnDate, formatter);

            Task pickedList = toDo.pickList(index);
            pickedList.setDate(newDate);

        } else if (in == 4) {
            System.out.print("Enter new Status :");
            String newStatus = scanner.nextLine();

            Task pickedList = toDo.pickList(index);
            pickedList.setStatus(newStatus);

            if (newStatus.toLowerCase().equals("done")) {
                toDo.remove(in);
            } else if (newStatus.toLowerCase().equals("active")) {
                return;
            } else {
                System.out.println("Please enter Active or Done");
            }

        } else if (in == 5) {
            toDo.cancel(index);
            System.out.println("\n ************ Task removed ************** \n");
        } else {

            System.out.println("Please choose a valid option. Press (Enter)");
            System.in.read(); // requires (Enter) to restart the code, in case of an invalid entry.

        }
    }

    void SaveAndQuit() {

        FileHandler fileHandler = new FileHandler();

        fileHandler.writeWhole(toDo);
        System.out.println("Saved and Quit");

        exit++; // Breaks While loop in main method.

    }

    void QuitWithoutSave() {

        System.out.println("Quit");

        exit++; // Breaks While loop in main method.

    }

    void startProcess() throws IOException {


        ListMenuItems();

        int in = scanner.nextInt(); //Get user's choice
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

        } else if (in == 5) {
            SaveAndQuit();

        } else {
            System.out.println("Please choose a valid option. Press (Enter)");
            System.in.read(); // requires (Enter) to restart the code, in case of an invalid entry.
        }
    }
}


