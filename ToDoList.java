import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;



public class ToDoList implements Serializable {
    protected ArrayList<ToDoList> lists;
    protected ArrayList<ToDoList> exList;
    protected String project;
    protected String title;
    protected String status;
    protected LocalDate date;

    private String path = "/Users/eris/Desktop/IP2/";


    public ToDoList() {
        this.lists = new ArrayList<>();
        this.exList = new ArrayList<>();
    }

    public ToDoList(String subject, String title, String status, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.project = subject;
        this.date = LocalDate.parse(date, formatter);
        this.title = title;
        this.status = status;
    }

    public String toString() {

        // Color codes for text
          final String ANSI_RESET = "\u001B[0m";
          final String ANSI_RED = "\u001B[31m";
          final String ANSI_GREEN = "\u001B[32m";

          final String ANSI_PURPLE = "\u001B[35m";
          final String ANSI_YELLOW = "\033[0;33m";


        return "" + ANSI_YELLOW + "Project :" + ANSI_GREEN + project + ANSI_YELLOW + "  Title :" + ANSI_GREEN + title
                + ANSI_YELLOW + "  Status :" + ANSI_GREEN + status +   ANSI_YELLOW + " Due Date:" + ANSI_GREEN + date + ANSI_RESET;


    }


    public void addItem(ToDoList task) {

        lists.add(task);
    }

    public void print() {
        int i = 1;
        for (ToDoList element : lists) {
            System.out.println(i + ": " + element);
            i++;
        }
    }

    public int getSize() {
        return lists.size();
    }

    public String getProject(){
        return project;
    }

    public String getTitle(){
        return title;
    }

    public String getStatus(){
        return status;
    }

    public LocalDate getDate(){
        return date;
    }


    public int getExListSize() {
        return exList.size();
    }


    public void remove(int number) {
        exList.add(lists.get(number - 1));
        lists.remove(number - 1);
    }



    public void sortByDate(ArrayList<ToDoList> list) {
        Collections.sort(list, new CompareToSortDate());
        print();
    }

    public void sortByProject(ArrayList<ToDoList> list) {
        Collections.sort(list, new CompareToSortProject());
        print();
    }

  //  public void edit







 public void writeAsObject(ArrayList<ToDoList> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "output.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File not found " +  e);
        }

    }

    public ArrayList<ToDoList> readAsObject()
    {
        ArrayList<ToDoList> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "output.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            lists = (ArrayList<ToDoList>) stream.readObject();

            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File not found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return list;
    }


    }