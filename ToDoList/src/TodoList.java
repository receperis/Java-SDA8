import java.util.ArrayList;
import java.util.Scanner;
public class TodoList {
    private ArrayList<String> lists;
    private ArrayList<String> exlist;


    public TodoList(){
        this.lists = new ArrayList<>();
        this.exlist = new ArrayList<>();
    }

    public void add(String task){
        lists.add(task);
    }

    public void print(){
        int i=1;
        for (String list: lists){
            System.out.println(i+": " + list);
            i++;
        }
    }

    public int getSize(){
        return lists.size();
    }

    public int getExListSize(){
        return exlist.size();
    }

    public void remove(int number){
        lists.remove(number-1);
        exlist.add(lists.get(number-1));

    }

}