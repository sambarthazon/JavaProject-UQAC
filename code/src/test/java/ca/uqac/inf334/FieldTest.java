package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Field field = new Field("Field");

    Course course = new Course("Course");

    Student student = new Student("Student", "1", "22/11/02");

    @Test
    public void TestUniversity(){
        field.SetUniversity(uqac);
        assertEquals(field.university, uqac);

        course.SetUniversity(uqac);
        course.AddField(field);
        student.SetUniversity(uqac);
        student.SetField(field);

        field.SetUniversity(cegep);
        assertEquals(field.university, cegep);
        assertFalse(field.studentList.contains(student));
        assertFalse(field.coursesList.contains(course));
    }

    @Test
    public void TestCourse(){
        field.SetUniversity(uqac);
        course.SetUniversity(cegep);

        field.AddCourse(course);
        assertFalse(field.coursesList.contains(course));

        course.SetUniversity(uqac);
        course.AddField(field);

        field.AddCourse(course);
        assertTrue(field.coursesList.contains(course));


        field.RemoveCourse(course);
        assertFalse(field.coursesList.contains(course));
    }

    @Test
    public void TestStudent(){
        field.SetUniversity(uqac);
        student.SetUniversity(cegep);

        field.AddStudent(student);
        assertFalse(field.studentList.contains(student));

        student.SetUniversity(uqac);

        field.AddStudent(student);
        assertTrue(field.studentList.contains(student));

        field.RemoveStudent(student);
        assertFalse(field.studentList.contains(student));
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + field.name + "\"," +
                "\n\t\t\t\"Courses list\" : " + field.coursesList + "," +
                "\n\t\t\t\"Student list\" : " + field.studentList + "\n\t\t}", field.toJSON());
    }
}
