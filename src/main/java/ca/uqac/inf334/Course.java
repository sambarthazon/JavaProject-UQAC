package ca.uqac.inf334;

import java.util.HashSet;

public class Course {
    String name;
    University university;
    Professor professor;
    Room room;
    HashSet<Student> studentList = new HashSet<>();
    HashSet<Field> fieldList = new HashSet<>();

    /**
     * Course's constructor
     * @param name
     */
    public Course(String name){
        this.name = name;
        this.university = null;
        this.professor = null;
        this.room = null;
    }


    /**
     * Set a new university to the course.
     * The course can only have one university. If we set a university to a course which it already has one,
     * its attributes will be reset.
     * @param newUniversity
     */
    public void SetUniversity(University newUniversity){
        System.out.println("---------- Set university (course) ----------");
        if (this.university != newUniversity) { // If the course's university isn't equal to the new university
            if (this.university != null) { // If the course's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university); // Remove the university of the course
            }
            if (newUniversity != null) { // If the new university isn't null
                this.university = newUniversity;
                newUniversity.AddCourse(this); // Add the course to the new university
            }
        }
    }

    /**
     * Remove the university of the course.
     * This action also delete the professor, the room, the students and the fields of the course.
     * @param university
     */
    public void RemoveUniversity(University university){
        System.out.println("---------- Remove university (course) ----------");
        if (this.university != null) { // If the course's university is equal to the university
            this.university = null;
            university.RemoveCourse(this); // Remove the course from the university
            for (Student student: studentList){ // Remove all students
                this.RemoveStudent(student);
            }
            this.RemoveProfessor(this.professor); // Remove the professor of the course
            this.RemoveRoom(this.room); // Remove the room of the course
            for(Field field: fieldList){ // Remove all fields
                this.RemoveField(field);
            }
            System.out.println(this + " course has no longer university.\n");
        } else {
            System.out.println(this + " course isn't in the university.\n");
        }
    }


    /**
     * Set a new professor to the course.
     * The course can only have one professor, their university must be the same.
     * If we set a professor to a course which it already has one, the old professor will be removed.
     * @param newProfessor
     */
    public void SetProfessor(Professor newProfessor){
        System.out.println("---------- Set professor (course) ----------");
        if (this.professor != newProfessor) { // If the course's professor isn't equal to the new professor
            if (this.university.equals(newProfessor.university)) { // If the course's university is equal to the professor's university
                if (this.professor != null) { // If the course's professor isn't null
                    final Professor oldProfessor = this.professor;
                    this.RemoveProfessor(this.professor); // Remove the professor of the course
                }
                if (newProfessor != null) {
                    this.professor = newProfessor;
                    newProfessor.SetCourse(this); // Set this course to the professor
                }
            } else {
                System.out.println(newProfessor + " isn't in the same university.");
            }
        } else {
            System.out.println(this.professor + " is already the professor.");
        }
    }

    /**
     * Remove the professor of the course.
     * This action also remove the course of the professor.
     * @param professor
     */
    public void RemoveProfessor(Professor professor){
        System.out.println("---------- Remove professor (course) ----------");
        if (this.professor != null) { // If the course's professor is equal to the professor
            this.professor = null;
            System.out.println(professor + " no longer teach this course.");
            professor.RemoveCourse(this); // Remove the course of the professor
        } else {
            System.out.println(professor + " doesn't teach this course.");
        }
    }


    /**
     * Set a room to the course.
     * The course's university and the new room must be in the same university.
     * @param newRoom
     */
    public void SetRoom(Room newRoom){
        System.out.println("---------- Set room (course) ----------");
        if (this.room != newRoom) { // If the course's room isn't equal to the new room
            if (this.room != null) { // If the course's room isn't null
                final Room oldRoom = this.room;
                this.RemoveRoom(this.room); // Remove the room of the course
            }
            if (newRoom != null) {
                this.room = newRoom;
                newRoom.SetCourse(this); // Set the course to the room
            }
        } else {
            System.out.println("The course already take place in this room.");
        }
    }

    /**
     * Remove the course's room.
     * This action also remove the course of the room.
     * @param room
     */
    public void RemoveRoom(Room room){
        System.out.println("---------- Remove room (course) ----------");
        if (this.room != null) { // If the course's room is equal to the room
            this.room = null;
            System.out.println(room + " no longer host the course.");
            room.RemoveCourse(this); // Remove the course from the room
        } else {
            System.out.println(room + " doesn't host this course.");
        }
    }


    /**
     * Add a student to the course.
     * The course's university and the student's university must be the same.
     * This action also add the course to the student and add the student to the professor's student list.
     * @param student
     */
    public void AddStudent(Student student){
        System.out.println("---------- Add student (course) ----------");
        if (this.university.equals(student.university)) { // If the course's university is equal to the student's university
            if (!studentList.contains(student)) { // If the student list doesn't contain the student
                studentList.add(student); // Add the student to the list
                System.out.println(student + " is now in this course.");
                student.AddCourse(this); // Add the course to the student
                this.professor.AddStudent(student); // Add the student to the professor
            } else {
                System.out.println(student + " is already in this course.");
            }
        } else {
            System.out.println("Not in the same university.");
        }
    }

    /**
     * Remove a student from the course's student list.
     * This action also remove the course of the student and remove the student from the professor's student list.
     * @param student
     */
    public void RemoveStudent(Student student){
        System.out.println("---------- Remove student (course) ----------");
        if (studentList.contains(student)) { // If the student list contain the student
            studentList.remove(student); // Remove the student from the list
            System.out.println(student + " removed from " + this + "'s student list.");
            student.RemoveCourse(this); // Remove the course to the student
            this.professor.RemoveStudent(student); // Remove the student to the professor
        } else {
            System.out.println(student + " doesn't exist in " + this + "'s student list.");
        }
    }


    /**
     * Add a field to the course's field list.
     * The course's university and field's university must be the same.
     * This action also add the course to the field's course list.
     * @param field
     */
    public void AddField(Field field){
        System.out.println("---------- Add field (course) ----------");
        if (this.university.equals(field.university)) { // If the course's university is equal to the field's university
            if (!fieldList.contains(field)) { // If the field list doesn't contain the field
                fieldList.add(field); // Add the field to the list
                System.out.println(field + " is now a field of this course.");
                field.AddCourse(this); // Add the course to the field
            } else {
                System.out.println(field + " is already a field of this course.");
            }
        } else {
            System.out.println("Not in the same university.");
        }
    }

    /**
     * Remove a field from the course's field list.
     * This action also remove the course from the field's course list.
     * @param field
     */
    public void RemoveField(Field field){
        System.out.println("---------- Remove field (course) ----------");
        if (fieldList.contains(field)) { // If the field list contains the field
            fieldList.remove(field); // Remove the field from the list
            System.out.println(field + " removed from " + this + "'s field list.");
            field.RemoveCourse(this); // Remove the course from the field
        } else {
            System.out.println(field + " doesn't exist in " + this + "'s field list.");
        }
    }


    /**
     * @return course name
     */
    public String toString(){
        return "\"" + this.name + "\"";
    }


    /**
     * Convert course in JSON syntax
     * @return str
     */
    public String toJSON(){
        String str = "\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + this.name + "\"," +
                "\n\t\t\t\"Professor\" : " + this.professor + "," +
                "\n\t\t\t\"Field list\" : " + this.fieldList + "," +
                "\n\t\t\t\"Room\" : \"" + this.room + "\"\n\t\t}";
        return str;
    }
}