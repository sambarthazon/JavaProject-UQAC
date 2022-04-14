package ca.uqac.inf334;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    University uqac = new University("UQAC");

    Course course1 = new Course("Course1");
    Course course2 = new Course("Course2");

    Room room = new Room(uqac);

    @Test
    public void TestGenerateRoom(){
        // Tested with the instance of the room
    }

    @Test
    public void TestCourse(){
        room.SetCourse(course1);
        assertEquals(room.course, course1);

        room.SetCourse(course2);
        assertEquals(room.course, course2);
    }

    @Test
    public void TestToJSON(){
        assertEquals("\n\t\t{" +
                "\n\t\t\t\"Course\" : " + room.course + "," +
                "\n\t\t\t\"Room number\" : \"" + room.room + "\"\n\t\t}", room.toJSON());
    }
}
