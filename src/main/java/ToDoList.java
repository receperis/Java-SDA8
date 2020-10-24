
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class ToDoList implements Serializable {
    private ArrayList<Task> activeLists;
    private ArrayList<Task> exList;




    public ToDoList() {

        this.activeLists = new ArrayList<>();
        this.exList = new ArrayList<>();
    }

    public ArrayList<Task> getActiveList(){ return activeLists;}
    public ArrayList<Task> getExList(){ return exList;}

    public void print(ArrayList<Task> list) {
        int i = 1;
        for (Task element : list) {
            System.out.println(i + ": " + element);
            i++;  // lists each element in the array list with a number next to them
        }
        System.out.println("\n ------- End of Line ----\n");


    }

    public void addItem(Task task) {

        activeLists.add(task);
    }


    public int getSize() {
        return activeLists.size();
    }

    public Task pickList(int number) {
        return activeLists.get(number - 1);
    }

    public int getExListSize() {
        return exList.size();
    }


    public void remove(int number) { //transfers active tasks to done tasks
        exList.add(activeLists.get(number - 1));
        activeLists.remove(number - 1);
    }

    public void cancel(int number) {
        activeLists.remove(number - 1);
    }


    public void sortByDate(ArrayList<Task> list) {
        Collections.sort(list, new CompareToSortDate());
        print(activeLists);
    }

    public void sortByProject(ArrayList<Task> list) {
        Collections.sort(list, new CompareToSortProject());
        print(activeLists);
    }
}

