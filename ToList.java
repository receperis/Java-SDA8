/*import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToList implements Serializable
{
    private String name;
    private LocalDate birthday;
    private int age;
    private String type;

    public ToDoList(String name, String date, int age, String type)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.name = name;
        this.birthday = LocalDate.parse(date, formatter);
        this.age = age;
        this.type = type;
    }

    public ToDoList(){}

    @Override
    public String toString()
    {

        //return "name" + name + "birthady" + birthday + "age" + age + "type" + type ;
        //           b      -   2000           -10-22   -    3      -   cat
        return "" + name + "**" + birthday + "**" + age + "**" + type ;

    }

    public static void main(String[] args) throws IOException
    {
        ToDoList a1 = new ToDoList("a" , "2000-10-22", 2, "dog");
        ToDoList a2 = new ToDoList("b" , "2000-10-14", 3, "cat");
        ToDoList a3 = new ToDoList("c" , "3000-10-21", 5, "dog");

        ArrayList<ToDoList> animalList = new ArrayList<>();
        animalList.add(a1);
        animalList.add(a2);
        animalList.add(a3);

        FileHandler fileHandler = new FileHandler();

        // write & read as data
        fileHandler.writeAsData(animalList);
        ArrayList<ToDoList> checkData = fileHandler.readAsData();
        System.out.println(checkData);
        System.out.println("----------------------");


        // write and read as object
        fileHandler.writeAsObject(animalList);
        ArrayList<ToDoList> checkObject = fileHandler.readAsObject();
        System.out.println(checkObject);
        System.out.println(checkObject.get(0));


        // RandomAccessFile




    }





} */
