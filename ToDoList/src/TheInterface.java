import java.util.Scanner;

public class TheInterface {
    public TodoList todoList;
    public Scanner scanner;

    public TheInterface(TodoList todolist, Scanner scanner){
        this.todoList = todolist;
        this.scanner = scanner;

    }

    void welcome(){
        System.out.println(">> Welcome to To Do List");


    }

    void start(){
        System.out.println(">> You have " + todoList.getSize() + " tasks to do " +
                "and " + todoList.getExListSize() + " tasks are done");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add new task");
        System.out.println(">> (3) Edit Task");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> Pick an option:");




        //Get user's choice
        int x=1;
        int in=scanner.nextInt();
        scanner.nextLine();

        //Display the title of the chosen module
        do{
            switch (in) {
                case 1: System.out.println("List of active tasks");
                    this.todoList.print();
                    System.out.println("**************************");
                    start();
                    break;
                case 2: System.out.println("Please write the task:");
                    String newTask=scanner.nextLine();
                    this.todoList.add(newTask);
                    System.out.println(newTask + " added to the list");
                    System.out.println("**************************");
                    start();
                    break;
                case 3: System.out.println("Choose which task to remove");
                    todoList.print();
                    int removal = scanner.nextInt();
                    this.todoList.remove(removal);
                    System.out.println("Task removed");
                    System.out.println("**************************");
                    start();
                    break;
                case 4: System.out.println("Saved and Quit");
                    x=2;
                    break;
                default: System.out.println("Please choose a valid option");
                    start();
                    break;
            }} while (x==1);




     /*  do {
       if (in==1) {
           System.out.println("You have " + todoList.getSize() + " active tasks");
       } else if (in==2) {
           System.out.println("Enter your new task :");
           String newTask = scanner.nextLine();
           todoList.add(newTask);
           break;
       } else if (in==3) {
           System.out.println("Enter the task no to remove:");
           todoList.print();
           int taskNo = scanner.nextInt();
           todoList.remove(taskNo);
       } else if (in==4) {
           x=2;
           break;
       }
    } while (x==1);   */



    }}