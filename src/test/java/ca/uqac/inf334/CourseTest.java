package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Professor professor1 = new Professor("Professor", "1");
    Professor professor2 = new Professor("Professor", "2");

    Field field = new Field("Field");

    Course course = new Course("Course");

    Student student = new Student("Student", "1", "22/11/02");

    Room room1 = new Room(uqac);
    Room room2 = new Room(uqac);

    @Test
    public void TestUniversity(){
        professor1.SetUniversity(uqac);
        field.SetUniversity(uqac);

        course.SetUniversity(uqac);
        assertEquals(course.university, uqac);

        student.SetUniversity(uqac);
        student.SetField(field);
        course.SetProfessor(professor1);
        course.AddField(field);
        course.AddStudent(student);
        course.SetRoom(room1);

        course.SetUniversity(cegep);
        assertNull(course.professor);
        assertNull(course.room);
        assertFalse(course.fieldList.contains(field));
        assertFalse(course.studentList.contains(student));
    }

    @Test
    public void TestProfessor(){
        professor1.SetUniversity(uqac);
        field.SetUniversity(uqac);
        course.SetUniversity(cegep);

        course.SetProfessor(professor1);
        assertNull(course.professor);

        course.SetUniversity(uqac);
        course.SetProfessor(professor1);
        assertEquals(course.professor, professor1);

        student.SetUniversity(uqac);
        student.SetField(field);
        course.AddStudent(student);
        professor2.SetUniversity(uqac);

        course.SetProfessor(professor2);
        assertEquals(course.professor, professor2);
    }

    @Test
    public void TestRoom(){
        course.SetRoom(room1);
        assertEquals(course.room, room1);

        course.SetRoom(room2);
        assertEquals(course.room, room2);
    }

    @Test
    public void TestStudent(){
        professor1.SetUniversity(uqac);
        course.SetUniversity(uqac);
        course.SetProfessor(professor1);
        field.SetUniversity(uqac);
        course.AddField(field);

        course.AddStudent(student);
        assertFalse(course.studentList.contains(student));

        student.SetUniversity(uqac);
        student.SetField(field);

        course.AddStudent(student);
        course.AddStudent(student);
        assertTrue(course.studentList.contains(student));

        course.RemoveStudent(student);
        course.RemoveStudent(student);
        assertFalse(course.studentList.contains(student));
    }

    @Test
    public void TestField(){
        course.SetUniversity(uqac);

        course.AddField(field);
        assertFalse(course.fieldList.contains(field));

        field.SetUniversity(uqac);

        course.AddField(field);
        assertTrue(course.fieldList.contains(field));

        course.RemoveField(field);
        assertFalse(course.fieldList.contains(field));
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + course.name + "\"," +
                "\n\t\t\t\"Professor\" : " + course.professor + "," +
                "\n\t\t\t\"Field list\" : " + course.fieldList + "," +
                "\n\t\t\t\"Room\" : \"" + course.room + "\"\n\t\t}", course.toJSON());
    }
}
