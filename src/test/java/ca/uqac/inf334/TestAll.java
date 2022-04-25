package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAll {

    University uqac = new University("UQAC");
    University cegep = new University("CEGEP");


    /**
     * Tests admin (100%)
     */
    Admin admin = new Admin("1", "Admin");

    @Test
    public void TestUniversityForAdmin(){
        admin.SetUniversity(uqac);
        assertEquals(uqac, admin.university);
        assertTrue(uqac.adminList.contains(admin));
        admin.SetUniversity(cegep);
    }

    @Test
    public void TestToJSONForAdmin() {
        assertEquals("\n\t\t{\n" +
                "\t\t\t\"Firstname\" : \"" + admin.firstName + "\"" +
                ",\n\t\t\t\"Lastname\" : \"" + admin.lastName + "\"" +
                ",\n\t\t\t\"Function\" : \"" + admin.function + "\"\n\t\t}", admin.toJSON());
    }



    /**
     * Tests secretary (100%)
     */
    Secretary secretary = new Secretary("1", "Secretary");

    @Test
    public void TestUniversityForSecretary(){
        secretary.SetUniversity(uqac);
        assertEquals(uqac, secretary.university);
        assertTrue(uqac.secretaryList.contains(secretary));
        secretary.SetUniversity(cegep);
    }

    @Test
    public void TestToJSONForSecretary(){
        assertEquals("\n\t\t{\n" +
                "\t\t\t\"Firstname\" : \"" + secretary.firstName + "\"" +
                ",\n\t\t\t\"Lastname\" : \"" + secretary.lastName + "\"" +
                ",\n\t\t\t\"Function\" : \"" + secretary.function + "\"\n\t\t}", secretary.toJSON());
    }



    /**
     * Tests professor (100%)
     */

    Professor professor = new Professor("Professor", "1");

    Field field = new Field("Field");

    Student student = new Student("Student", "1", "22/11/02");

    @Test
    public void TestUniversityForProfessor(){
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
    public void TestCourseForProfessor(){
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
    public void TestStudentForProfessor(){
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
    public void TestToJSONForProfessor(){
        assertEquals("\n\t\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + professor.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + professor.lastName + "\"," +
                "\n\t\t\t\"Function\" : \"" + professor.function + "\"," +
                "\n\t\t\t\"Course\" : " + professor.course + "," +
                "\n\t\t\t\"Student list\" : " + professor.studentList + "\n\t\t\t}", professor.toJSON());
    }



    /**
     * Tests student (100%)
     */
    Professor professor1 = new Professor("Prof", "1");

    Student sam = new Student("BARTHAZON", "Sam", "22/11/02"); // Test attributes and permanent code

    Field field1 = new Field("Field1");
    Field field2 = new Field("Field2");

    Course course1 = new Course("Course1");
    Course course2 = new Course("Course2");

    Sport sport = new Sport("Sport", uqac);

    @Test
    public void TestUniversityForStudent(){
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

    @Test
    public void TestFieldForStudent(){
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
    public void TestAddCourseForStudent(){
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
    public void TestRemoveCourseForStudent(){
        // Tested with test field
    }

    @Test
    public void TestSportForStudent(){
        sam.AddSport(sport);
        assertTrue(sam.sportList.contains(sport));
        sam.RemoveSport(sport);
        assertFalse(sam.sportList.contains(sport));
    }

    @Test
    public void TestToStringForStudent(){
        // Tested when we print the student
    }

    @Test
    public void TestToJSONForStudent(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + sam.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + sam.lastName + "\"," +
                "\n\t\t\t\"Birthday\" : \"" + sam.birthday + "\"," +
                "\n\t\t\t\"Permanent Code\" : \"" + sam.permanentCode + "\"," +
                "\n\t\t\t\"Field\" : " + sam.field + "," +
                "\n\t\t\t\"Courses list\" : " + sam.coursesList + "," +
                "\n\t\t\t\"Sport list\" : " + sam.sportList + "\n\t\t}", sam.toJSON());
    }


    /**
     * Tests course (97%)
     */
    Professor professor2 = new Professor("Professor", "2");

    Course course = new Course("Course");

    Room room1 = new Room(uqac);
    Room room2 = new Room(uqac);

    @Test
    public void TestUniversityForCourse(){
        professor1.SetUniversity(uqac);
        field.SetUniversity(uqac);

        course.SetUniversity(uqac);
        assertEquals(course.university, uqac);

        student.SetUniversity(uqac);
        student.SetField(field);
        course.SetProfessor(professor1);
        course.AddStudent(student);
        course.AddField(field);
        course.SetRoom(room1);

        course.SetUniversity(cegep);
        assertNull(course.professor);
        assertNull(course.room);
        assertFalse(course.fieldList.contains(field));
        assertFalse(course.studentList.contains(student));
    }

    @Test
    public void TestProfessorForCourse(){
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
    public void TestRoomForCourse(){
        course.SetRoom(room1);
        assertEquals(course.room, room1);

        course.SetRoom(room2);
        assertEquals(course.room, room2);
    }

    @Test
    public void TestStudentForCourse(){
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
    public void TestFieldForCourse(){
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
    public void TestToJSONForCourse(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + course.name + "\"," +
                "\n\t\t\t\"Professor\" : " + course.professor + "," +
                "\n\t\t\t\"Field list\" : " + course.fieldList + "," +
                "\n\t\t\t\"Room\" : \"" + course.room + "\"\n\t\t}", course.toJSON());
    }


    /**
     * Test field (93%)
     */
    @Test
    public void TestUniversityForField(){
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
    public void TestCourseForField(){
        field.SetUniversity(uqac);
        course.SetUniversity(cegep);

        field.AddCourse(course);
        assertFalse(field.coursesList.contains(course));

        course.SetUniversity(uqac);

        field.AddCourse(course);
        assertTrue(field.coursesList.contains(course));

        field.RemoveCourse(course);
        assertFalse(field.coursesList.contains(course));
    }

    @Test
    public void TestStudentForField(){
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
    public void TestToJSONForField(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + field.name + "\"," +
                "\n\t\t\t\"Courses list\" : " + field.coursesList + "," +
                "\n\t\t\t\"Student list\" : " + field.studentList + "\n\t\t}", field.toJSON());
    }

    /**
     * Tests room (100%)
     */
    Room room = new Room(uqac);

    @Test
    public void TestGenerateRoom(){
        // Tested with the instance of the room
    }

    @Test
    public void TestCourseForRoom(){
        room.SetCourse(course1);
        assertEquals(room.course, course1);

        room.SetCourse(course2);
        assertEquals(room.course, course2);
    }

    @Test
    public void TestToJSONForRoom(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Course\" : " + room.course + "," +
                "\n\t\t\t\"Room number\" : \"" + room.room + "\"\n\t\t}", room.toJSON());
    }


    /**
     * Tests sport (100%)
     */
    @Test
    public void TestStudentForSport(){
        sport.AddStudent(student);
        assertTrue(sport.studentList.contains(student));

        sport.RemoveStudent(student);
        assertFalse(sport.studentList.contains(student));
    }

    @Test
    public void TestToJSONForSport(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + sport.name + "\"," +
                "\n\t\t\t\"Student list\" : " + sport.studentList + "\n\t\t}", sport.toJSON());
    }


    /**
     * Tests university (53%)
     */
    Admin admin2 = new Admin("Admin", "2");
    Secretary secretary2 = new Secretary("Secretary", "2");
    Student student2 = new Student("Student", "2", "22/11/02");
    Sport sport2 = new Sport("Sport2", uqac);

    @Test
    public void TestAdminForUniversity(){
        uqac.AddAdmin(admin);
        assertTrue(uqac.adminList.contains(admin));
        uqac.AddAdmin(admin);

        uqac.RemoveAdmin(admin);
        assertFalse(uqac.adminList.contains(admin));
        uqac.RemoveAdmin(admin);
    }

    @Test
    public void TestSecretaryForUniversity(){
        uqac.AddSecretary(secretary);
        assertTrue(uqac.secretaryList.contains(secretary));
        uqac.AddSecretary(secretary);

        uqac.RemoveSecretary(secretary);
        assertFalse(uqac.secretaryList.contains(secretary));
        uqac.RemoveSecretary(secretary);
    }

    @Test
    public void TestProfessorForUniversity(){
        uqac.AddProfessor(professor);
        assertTrue(uqac.professorList.contains(professor));
        uqac.AddProfessor(professor);

        uqac.RemoveProfessor(professor);
        assertFalse(uqac.professorList.contains(professor));
        uqac.RemoveProfessor(professor);
    }

    @Test
    public void TestRoomForUniversity(){
        uqac.AddRoom(room);
        assertTrue(uqac.roomList.contains(room));
        uqac.AddRoom(room);

        uqac.RemoveRoom(room);
        assertFalse(uqac.roomList.contains(room));
        uqac.RemoveRoom(room);
    }

    @Test
    public void TestStudentForUniversity(){
        uqac.AddStudent(student);
        assertTrue(uqac.studentList.contains(student));
        uqac.AddStudent(student);

        uqac.RemoveStudent(student);
        assertFalse(uqac.studentList.contains(student));
        uqac.RemoveStudent(student);
    }

    @Test
    public void TestCourseForUniversity(){
        uqac.AddCourse(course);
        assertTrue(uqac.coursesList.contains(course));
        uqac.AddCourse(course);

        uqac.RemoveCourse(course);
        assertFalse(uqac.coursesList.contains(course));
        uqac.RemoveCourse(course);
    }

    @Test
    public void TestFieldForUniversity(){
        uqac.AddField(field);
        assertTrue(uqac.fieldList.contains(field));
        uqac.AddField(field);

        uqac.RemoveField(field);
        assertFalse(uqac.fieldList.contains(field));
        uqac.RemoveField(field);
    }

    @Test
    public void TestSportForUniversity(){
        uqac.AddSport(sport);
        assertTrue(uqac.sportList.contains(sport));
        uqac.AddSport(sport);

        sport.AddStudent(student);

        uqac.RemoveSport(sport);
        assertFalse(uqac.sportList.contains(sport));
        uqac.RemoveSport(sport);
    }

    @Test
    public void TestToJSONForUniversity(){
        uqac.AddAdmin(admin);
        uqac.AddAdmin(admin2);
        uqac.AddSecretary(secretary);
        uqac.AddSecretary(secretary2);
        uqac.AddProfessor(professor);
        uqac.AddProfessor(professor2);
        uqac.AddStudent(student);
        uqac.AddStudent(student2);
        uqac.AddCourse(course);
        uqac.AddCourse(course2);
        uqac.AddField(field);
        uqac.AddField(field2);
        uqac.AddSport(sport);
        uqac.AddSport(sport2);
        uqac.AddRoom(room);

        uqac.toJSON();
        System.out.println(uqac.toJSON());
    }

}
