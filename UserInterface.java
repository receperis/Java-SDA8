import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ToDoList theList;
    private Scanner scanner;
    public int exit = 1; // Integer in order to break while loop in main method

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
        System.out.println("Press (P) to Sort Tasks by Subject \n" +
                           "Press (D) to Sort Tasks by Date");

        String in = scanner.nextLine();

        if(in.equals("p") || in.equals("P") ) {
            theList.sortByProject(theList.lists);

        } else if (in.equals("d") || in.equals("D") ) {
            theList.sortByDate(theList.lists);

        } else {
            System.out.println("Not a valid choice");
        }

        System.out.println("Press (Enter) to restart");
    }

    void AddNewTask() {
        //color codes for the visual purposes
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

    void EditTask() throws IOException {


        System.out.println("Choose a task number to edit");
        theList.print();

        int lst = scanner.nextInt(); //Get user's choice for edit
        scanner.nextLine(); // to clean the scanner

        System.out.println(">> (1) Update Project");
        System.out.println(">> (2) Update Title");
        System.out.println(">> (3) Update Date");
        System.out.println(">> (4) Update Status");
        System.out.println(">> (5) Remove/Cancel \n");

        System.out.println("Pick an edit option");

        int in = scanner.nextInt(); //Get user's choice for edit
        scanner.nextLine(); // to clean the scanner



        //Display the title of the chosen module
        if (in == 1) {
            System.out.println("Enter new Project");
            String newProject = scanner.nextLine();

            ToDoList pickedList = theList.pickList(lst);
            pickedList.setProject(newProject);

        }else if (in == 2){
            System.out.println("Enter new Title");
            String newTitle = scanner.nextLine();

            ToDoList pickedList = theList.pickList(lst);
            pickedList.setTitle(newTitle);

        }else if (in == 3) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Enter new Date");
            String scnDate = scanner.nextLine();

            LocalDate newDate = LocalDate.parse(scnDate,formatter);

            ToDoList pickedList = theList.pickList(lst);
            pickedList.setDate(newDate);

        }else if (in == 4) {
            System.out.println("Enter new Status");
            String newStatus = scanner.nextLine();

            ToDoList pickedList = theList.pickList(lst);
            pickedList.setStatus(newStatus);

            if(newStatus.equals("done") || newStatus.equals("Done") ){
                theList.remove(in);
            }else if (newStatus.equals("active") || newStatus.equals("Active") ){
                return;
            } else {
                System.out.println("Please enter active or done");
            }



        } else if (in == 5) {
            theList.cancel(lst);
        } else {


            System.out.println("Please choose a valid option. Press (Enter)");
            System.in.read(); // requires (Enter) to restart the code, in case of an invalid entry.

            //int removal = scanner.nextInt();

            //theList.remove(removal);

            //System.out.println("************ Task removed ************** ");
        }
    }

     void SaveAndQuit() {

        ToDoList todolist = new ToDoList();

        todolist.writeAsObject(theList.lists);
        System.out.println("Saved and Quit");

        exit++; // Breaks While loop in main method.

    }

    void QuitWithoutSave() {

        System.out.println("Quit");

        exit++; // Breaks While loop in main method.

    }

    void startProcess() throws IOException {

       // while (1 == 1) {

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

            }  else {
                System.out.println("Please choose a valid option. Press (Enter)");
                System.in.read(); // requires (Enter) to restart the code, in case of an invalid entry.
            }
        }
    }


