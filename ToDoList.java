import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ToDoList implements Serializable {
    public ArrayList<String> lists;
    private ArrayList<String> exlist;
    private String subject;
    private String title;
    private LocalDate date;

    private String path = "/Users/eris/Desktop/java copy/src/";


    public ToDoList() {
        this.lists = new ArrayList<>();
        this.exlist = new ArrayList<>();
    }

    public ToDoList(String subject, String title, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.subject = subject;
        this.date = LocalDate.parse(date, formatter);
        this.title = title;
    }

    public String toString() {
        return "" + subject + "**" + title + "**" + date;

    }

    public void addItem(String task) {

        lists.add(task);
    }

    public void print() {
        int i = 1;
        for (String element : lists) {
            System.out.println(i + ": " + element);
            i++;
        }
    }

    public int getSize() {
        return lists.size();
    }

    public int getExListSize() {
        return exlist.size();
    }

    public void remove(int number) {
        exlist.add(lists.get(number - 1));
        lists.remove(number - 1);
    }

    void writeAsData(ArrayList<String> list) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/eris/Desktop/IP/output.txt"));
            for (String a : list) {
                bw.write(a + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File is not found " + e);
        }
    }


    public ArrayList<String> readAsData() {


        try {
            FileReader fileReader = new FileReader(new File("/Users/eris/Desktop/IP/output.txt"));
            BufferedReader br = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split("\\*\\*");
                ToDoList a = new ToDoList(data[0], data[1], data[2]);
                lists.add(a.toString());
            }

            br.close();
        } catch (IOException e) {
            System.out.println("File not found " + e);
        }


        return lists;
    }
}
/*
    public void writeAsObject(ArrayList<ToDoList> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "here.txt");
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
}

      public ArrayList<ToDoList> readAsObject()
    {
        ArrayList<ToDoList> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "here.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            list = (ArrayList<ToDoList>) stream.readObject();

            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File doesn't found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return list;
    }


}

 */