import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

class CompareToSortDate implements Comparator<ToDoList> {


    @Override
    public int compare(ToDoList e1, ToDoList e2) {
        return e1.getDate().compareTo(e2.getDate());

    }
}

