import java.io.*;
import java.util.ArrayList;

public class FileHandler implements Serializable {

    public String path = "/Users/eris/Desktop/IP2/";

    public void writeWhole(ToDoList list) {
        try {
            FileOutputStream file = new FileOutputStream(path + "output.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File not found " + e);
        }

    }


    public ToDoList readWhole() {
        ToDoList todoList = new ToDoList(); //
        try {
            FileInputStream file = new FileInputStream(path + "output.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // reads obeject to store file
            todoList = (ToDoList) stream.readObject();

            stream.close();
            file.close();

        } catch (IOException e) {
            System.out.println("File not found " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("problems inside the file " + e);
        }

        return todoList;
    }

}


