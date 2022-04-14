package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SportTest {

    University uqac = new University("UQAC");

    Student student = new Student("Student", "1", "22/11/02");

    Sport sport = new Sport("sport", uqac);

    @Test
    public void TestStudent(){
        sport.AddStudent(student);
        assertTrue(sport.studentList.contains(student));

        sport.RemoveStudent(student);
        assertFalse(sport.studentList.contains(student));
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + sport.name + "\"," +
                "\n\t\t\t\"Student list\" : " + sport.studentList + "\n\t\t}", sport.toJSON());
    }
}
