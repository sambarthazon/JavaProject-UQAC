package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {
    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Professor professor = new Professor("Professor", "1");

    Field field = new Field("Field");

    Course course1 = new Course("Course1");
    Course course2 = new Course("Course2");

    Student student = new Student("Student", "1", "22/11/02");

    @Test
    public void TestUniversity(){
        professor.SetUniversity(uqac);
        assertEquals(uqac, professor.university);
        assertTrue(uqac.professorList.contains(professor));

        field.SetUniversity(uqac);
        course1.SetUniversity(uqac);
        student.SetUniversity(uqac);
        student.SetField(field);
        professor.SetCourse(course1);
        professor.AddStudent(student);
        professor.SetUniversity(cegep);

        assertFalse(uqac.professorList.contains(professor));
    }

    @Test
    public void TestCourse(){
        professor.SetCourse(course1);
        assertNull(professor.course);

        professor.SetUniversity(uqac);
        professor.SetCourse(course1);
        assertNotEquals(professor.university, course1.university);

        course1.SetUniversity(uqac);
        professor.SetCourse(course1);
        assertEquals(course1, professor.course);

        course2.SetUniversity(uqac);
        field.SetUniversity(uqac);
        student.SetUniversity(uqac);
        student.SetField(field);
        professor.AddStudent(student);

        professor.SetCourse(course2);
        assertEquals(course2, professor.course);
    }

    @Test
    public void TestStudent(){
        professor.SetUniversity(uqac);
        field.SetUniversity(uqac);
        course1.SetUniversity(uqac);
        professor.SetCourse(course1);
        student.SetUniversity(cegep);

        professor.AddStudent(student);
        assertFalse(professor.studentList.contains(student));

        student.SetUniversity(uqac);
        professor.AddStudent(student);
        assertFalse(professor.studentList.contains(student));

        student.SetField(field);
        professor.AddStudent(student);
        assertTrue(professor.studentList.contains(student));

        professor.AddStudent(student);
        assertTrue(professor.studentList.contains(student));

        professor.RemoveStudent(student);
        professor.RemoveStudent(student);
        assertFalse(professor.studentList.contains(student));
    }



    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + professor.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + professor.lastName + "\"," +
                "\n\t\t\t\"Function\" : \"" + professor.function + "\"," +
                "\n\t\t\t\"Course\" : " + professor.course + "," +
                "\n\t\t\t\"Student list\" : " + professor.studentList + "\n\t\t\t}", professor.toJSON());
    }
}
