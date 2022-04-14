package ca.uqac.inf334;

public class Room {
    String room;
    University university;
    Course course;

    /**
     * Room"s Constructor
     * @param university
     */
    public Room (University university){
        this.room = GenerateRoom();
        this.university = university;
        this.course = null;
        university.AddRoom(this);
    }


    /**
     * Generate number's room
     * @return room
     */
    public String GenerateRoom(){
        System.out.println("---------- Generate room (room) ----------");
        int thousand = (int)(Math.random()*6);
        String str_thousand = String.valueOf(thousand);
        int hundred = (int)(Math.random()*10);
        String str_hundred = String.valueOf(hundred);
        int ten = (int)(Math.random()*10);
        String str_ten = String.valueOf(ten);
        int floor = (int)(Math.random()*6);
        String str_floor= String.valueOf(floor);

        room = "P" + str_floor + "-" + str_thousand + str_hundred + str_ten + "0";
        return room;
    }


    /**
     * Set a course to the room.
     * This action also remove the room of the course.
     * @param newCourse
     */
    public void SetCourse(Course newCourse){
        System.out.println("---------- Set course (room) ----------");
        if (this.course != newCourse) { // If the room's course isn't equal to the new course
            if (this.course != null) { // If the room's course isn't null
                final Course oldCourse = this.course;
                this.RemoveCourse(this.course); // Remove the course of the room
            }
            if (newCourse != null) { // If the new course isn't null
                this.course = newCourse;
                newCourse.SetRoom(this); // Set the room to the course
            }
        }
    }

    /**
     * Remove the course from the room.
     * This action also remove the course from the room.
     * @param course
     */
    public void RemoveCourse(Course course){
        System.out.println("---------- Remove course (room) ----------");
        if (this.course != null) { // If the room's course is equal to the course
            this.course = null;
            System.out.println(course + " no longer take place in this room.");
            course.RemoveRoom(this); // Remove the room to the course
        } else {
            System.out.println(course + " doesn't take place in this room.");
        }
    }


    /**
     * Return room toString
     * @return this.room
     */
    public String toString(){
        return this.room;
    }


    /**
     * Convert Room to JSON syntax
     * @return str
     */
    public String toJSON(){
        String str = "\n\t\t{" +
                "\n\t\t\t\"Course\" : " + this.course + "," +
                "\n\t\t\t\"Room number\" : \"" + this.room + "\"\n\t\t}";
        return str;
    }
}