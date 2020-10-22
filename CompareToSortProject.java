import java.util.Comparator;

public class CompareToSortProject implements Comparator<ToDoList> {


        @Override
        public int compare(ToDoList e1, ToDoList e2) {
            return e1.getProject().compareTo(e2.getProject());

        }
    }

