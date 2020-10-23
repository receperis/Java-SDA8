import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {

    protected String project;
    protected String title;
    protected String status;
    protected LocalDate date;

    public Task (String project, String title, String status, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.project = project;
        this.date = LocalDate.parse(date, formatter);
        this.title = title;
        this.status = status;
    }





    public String getProject(){
        return project;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setProject(String newProject){
        this.project = newProject;
    }

    public void setDate(LocalDate newDate){
        this.date = newDate;
    }

    public void setStatus(String newStatus){
        this.status=newStatus;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }



    public String toString() { // lists elements in the arraylist.

         //color codes for visual purposes
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\033[0;33m";


        return "" + ANSI_YELLOW + "Project :" + ANSI_GREEN + project + ANSI_YELLOW + "  Title :" + ANSI_GREEN + title
                + ANSI_YELLOW + "  Status :" + ANSI_GREEN + status + ANSI_YELLOW + " Due Date:" + ANSI_GREEN + date + ANSI_RESET;

    }
}
