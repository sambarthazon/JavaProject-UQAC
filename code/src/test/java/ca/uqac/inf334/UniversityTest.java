package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    University uqac = new University("UQAC");

    Admin admin = new Admin("Admin", "1");
    Secretary secretary = new Secretary("Secretary", "1");
    Professor professor = new Professor("Professor", "1");
    Student student = new Student("Student", "1", "22/11/02");
    Field field = new Field("Field");
    Course course = new Course("Course");
    Sport sport = new Sport("Sport", uqac);
    Room room = new Room(uqac);

    @Test
    public void TestAdmin(){
        uqac.AddAdmin(admin);
        assertTrue(uqac.adminList.contains(admin));
        uqac.AddAdmin(admin);

        uqac.RemoveAdmin(admin);
        assertFalse(uqac.adminList.contains(admin));
        uqac.RemoveAdmin(admin);
    }

    @Test
    public void TestSecretary(){
        uqac.AddSecretary(secretary);
        assertTrue(uqac.secretaryList.contains(secretary));
        uqac.AddSecretary(secretary);

        uqac.RemoveSecretary(secretary);
        assertFalse(uqac.secretaryList.contains(secretary));
        uqac.RemoveSecretary(secretary);
    }

    @Test
    public void TestProfessor(){
        uqac.AddProfessor(professor);
        assertTrue(uqac.professorList.contains(professor));
        uqac.AddProfessor(professor);

        uqac.RemoveProfessor(professor);
        assertFalse(uqac.professorList.contains(professor));
        uqac.RemoveProfessor(professor);
    }

    @Test
    public void TestRoom(){
        uqac.AddRoom(room);
        assertTrue(uqac.roomList.contains(room));
        uqac.AddRoom(room);

        uqac.RemoveRoom(room);
        assertFalse(uqac.roomList.contains(room));
        uqac.RemoveRoom(room);
    }

    @Test
    public void TestStudent(){
        uqac.AddStudent(student);
        assertTrue(uqac.studentList.contains(student));
        uqac.AddStudent(student);

        uqac.RemoveStudent(student);
        assertFalse(uqac.studentList.contains(student));
        uqac.RemoveStudent(student);
    }

    @Test
    public void TestCourse(){
        uqac.AddCourse(course);
        assertTrue(uqac.coursesList.contains(course));
        uqac.AddCourse(course);

        uqac.RemoveCourse(course);
        assertFalse(uqac.coursesList.contains(course));
        uqac.RemoveCourse(course);
    }

    @Test
    public void TestField(){
        uqac.AddField(field);
        assertTrue(uqac.fieldList.contains(field));
        uqac.AddField(field);

        uqac.RemoveField(field);
        assertFalse(uqac.fieldList.contains(field));
        uqac.RemoveField(field);
    }

    @Test
    public void TestSport(){
        uqac.AddSport(sport);
        assertTrue(uqac.sportList.contains(sport));
        uqac.AddSport(sport);

        sport.AddStudent(student);

        uqac.RemoveSport(sport);
        assertFalse(uqac.sportList.contains(sport));
        uqac.RemoveSport(sport);
    }

    @Test
    public void TestToJSON(){

    }

}
