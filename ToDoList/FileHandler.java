/*import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    //TODO change the path
    private String path = "/Users/eris/Desktop/SDA /Individual Project";

    //Data Stream :
    public void writeAsData(ArrayList<ToDoList> list)
    {

        try {
            FileWriter fileWriter = new FileWriter(new File(path + "here.txt"));
            BufferedWriter br = new BufferedWriter(fileWriter);

            for (ToDoList a : list)
            {
                br.write(a.toString() + "\n");
            }
            br.close();

        }
        catch (IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }

    }

    public ArrayList<ToDoList> readAsData()
    {
        ArrayList<ToDoList> list = new ArrayList<>();

        try
        {
            FileReader fileReader = new FileReader(new File("/Users/eris/Desktop/SDA /Individual Project/here.txt"));
            BufferedReader br = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ( (line = br.readLine()) != null )
            {
                data = line.split("\\*\\*");
                ToDoList a = new ToDoList(data[0],data[1], Integer.parseInt(data[2]), data[3]);
                list.add(a);
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }


        return list;
    }


    //--------------------------

    //Object Stream
    public void writeAsObject(ArrayList<ToDoList> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "objectNour.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(list);

            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }

    }

    public ArrayList<ToDoList> readAsObject()
    {
        ArrayList<ToDoList> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "objectNour.txt");
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
