package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");

    Professor professor1 = new Professor("Prof", "1");

    Student sam = new Student("BARTHAZON", "Sam", "22/11/02"); // Test attributes and permanent code

    Field field1 = new Field("Field1");
    Field field2 = new Field("Field2");

    Course course1 = new Course("Course1");
    Course course2 = new Course("Course2");

    Sport sport = new Sport("Sport", uqac);

    /**
     * Test set university and remove university
     */
    @Test
    public void TestUniversity(){
        sam.SetUniversity(uqac);
        assertEquals(uqac, sam.university);
        assertTrue(uqac.studentList.contains(sam));
        sam.AddSport(sport); // Test with line of sports
        sam.SetUniversity(cegep);
        assertEquals(sam.university, cegep);
        assertFalse(sam.sportList.contains(sport));
    }

    @Test
    public void TestPermanentCode(){
        // Tested with instance of sam
    }

    /**
     * Test set field and remove field
     */
    @Test
    public void TestField(){
        professor1.SetUniversity(uqac);
        field1.SetUniversity(uqac);
        field2.SetUniversity(uqac);
        course1.SetUniversity(uqac);
        professor1.SetCourse(course1);
        course1.AddField(field1);
        sam.SetUniversity(uqac);

        sam.SetField(field1);
        sam.AddCourse(course1);
        assertEquals(field1, sam.field);
        assertTrue(field1.studentList.contains(sam));
        sam.SetField(field2);
    }

    @Test
    public void TestAddCourse(){
        professor1.SetUniversity(uqac);
        field1.SetUniversity(uqac);
        course1.SetUniversity(uqac);
        course1.SetProfessor(professor1);
        course1.AddField(field1);
        course2.SetUniversity(uqac);
        course2.AddField(field2);
        sam.SetUniversity(uqac);

        sam.AddCourse(course1);
        assertFalse(sam.coursesList.contains(course1), "Sam hasn't a field");
        sam.SetField(field1);
        sam.AddCourse(course2);
        assertFalse(sam.coursesList.contains(course2), "Sam and course haven't the sam field");
        sam.AddCourse(course1);
        assertTrue(sam.coursesList.contains(course1));
    }

    @Test
    public void TestRemoveCourse(){
        // Tested with test field
    }

    @Test
    public void TestSport(){
        sam.AddSport(sport);
        assertTrue(sam.sportList.contains(sport));
        sam.RemoveSport(sport);
        assertFalse(sam.sportList.contains(sport));
    }

    @Test
    public void TestToString(){
        // Tested when we print the student
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + sam.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + sam.lastName + "\"," +
                "\n\t\t\t\"Birthday\" : \"" + sam.birthday + "\"," +
                "\n\t\t\t\"Permanent Code\" : \"" + sam.permanentCode + "\"," +
                "\n\t\t\t\"Field\" : " + sam.field + "," +
                "\n\t\t\t\"Courses list\" : " + sam.coursesList + "," +
                "\n\t\t\t\"Sport list\" : " + sam.sportList + "\n\t\t}", sam.toJSON());
    }
}
