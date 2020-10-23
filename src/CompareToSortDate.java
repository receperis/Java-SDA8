
import java.util.Comparator;

class CompareToSortDate implements Comparator<Task> {


    @Override
    public int compare(Task element1, Task element2) {
        return element1.getDate().compareTo(element2.getDate());

    }
}

