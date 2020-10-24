import java.util.Comparator;

public class CompareToSortProject implements Comparator<Task> {


    @Override
    public int compare(Task element1, Task element2) {
        return element1.getProject().compareTo(element2.getProject());

    }
}

