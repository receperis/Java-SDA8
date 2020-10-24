import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task T1 = new Task("p1", "t1", "s1", "2020-11-11");


    @Test
    void getProjectTest() {

        assertEquals("p1", T1.getProject());
    }

    @Test
    void getDateTest() {

        assertEquals(LocalDate.parse( "2020-11-11" ), T1.getDate());
    }

    @Test
    void setProject() {
        assertEquals("p1", T1.getProject());
        T1.setProject("p2");
        assertEquals("p2", T1.getProject());

    }

    @Test
    void setDateTest() {
        assertEquals(LocalDate.parse( "2020-11-11" ), T1.getDate());
        T1.setDate(LocalDate.parse( "2020-08-08" ));
        assertEquals(LocalDate.parse( "2020-08-08" ), T1.getDate());

    }

    @Test
    void setStatusTest() {
        assertEquals("s1", T1.getStatus());
        T1.setStatus("s2");
        assertEquals("s2", T1.getStatus());

    }

    @Test
    void setTitleTest() {
        assertEquals("t1", T1.getTitle());
        T1.setTitle("t2");
        assertEquals("t2", T1.getTitle());

    }
}


