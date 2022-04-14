package ca.uqac.inf334;

import java.util.HashSet;

public class Professor extends Staff {
    Course course;
    HashSet<Student> studentList = new HashSet<>();

    /**
     * Professor's constructor
     * @param firstName
     * @param lastName
     */
    public Professor(String firstName, String lastName){
        super(firstName, lastName, "Professor");
        this.course = null;
    }


    /**
     * Set the university to the professor.
     * This action also add the professor to the professor's admin list. If we set a university to an professor which it already has one,
     * its attributes will be reset.
     * @param newUniversity
     */
    public void SetUniversity(University newUniversity){
        System.out.println("---------- Set university (professor) ----------");
        if(this.university != newUniversity){ // If professor's university isn't equal to the new university
            if(this.university != null){ // If professor's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university);
            }
            if(newUniversity != null){ // If the new university isn't null
                this.university = newUniversity;
                System.out.println("Set university to : " + this);
                newUniversity.AddProfessor(this); // Add the professor to the new university
            }
        } else {
            System.out.println(this + " is already in this university.");
        }
    }

    /**
     * Remove the university of the professor.
     * This action also remove all the students from the student list, the course,
     * and the professor from the university's professor list.
     * @param university
     */
    public void RemoveUniversity(University university){
        System.out.println("---------- Remove university (professor) ----------");
        if (this.university != null) { // If professor's university is equal to the university
            for (Student student: studentList) { // Remove all students from his list
                this.RemoveStudent(student);
            }
            this.RemoveCourse(this.course); // Remove his course
            this.university = null;
            university.RemoveProfessor(this); // Remove professor from the university's list
            System.out.println(this + " professor has no longer university.");
        } else {
            System.out.println(this + " professor isn't in the university.");
        }
    }


    /**
     * Set the course to the professor.
     * The professor's university and the new course's university must be the same.
     * This action also remove all the students from the student list of the old course
     * and add the students to the student list of the new course.
     * @param newCourse
     */
    public void SetCourse(Course newCourse){
        System.out.println("---------- Set course (professor) ----------");
        if (this.university != null) { // If the university of the professor isn't null
            if (this.university.equals(newCourse.university)) { // If the professor's university is equal to the course's university
                if (this.course != newCourse) { // If the professor's course isn't equal to the new course
                    if (this.course != null) { //If the professor's course isn't null
                        final Course oldCourse = this.course;
                        this.RemoveCourse(this.course);
                    }
                    if (newCourse != null) { // If the new course isn't null
                        this.course = newCourse;
                        newCourse.SetProfessor(this); // Set to the new course this professor
                        this.studentList = newCourse.studentList; // The professor take all students of the course
                    }
                } else {
                    System.out.println("Professor " + this + " already have " + newCourse + " course.");
                }
            } else {
                System.out.println("Professor " + this + " and course " + newCourse + " aren't in the same university.");
            }
        } else {
            System.out.println(this + " hasn't university.");
        }
    }

    /**
     * Remove the course of the professor.
     * This action also remove all students from the student list.
     * @param course
     */
    public void RemoveCourse(Course course){
        System.out.println("---------- Remove course (professor) ----------");
        if (this.course != null) { // If professor's course is equal to the course
            this.course = null;
            course.RemoveProfessor(this); // Remove the professor of the course
            for (Student student: studentList) { // Remove all the students in the list
                this.RemoveStudent(student);
            }
            System.out.println(this + " professor has no longer course.");
        } else {
            System.out.println(this + " professor hasn't this course.");
        }
    }


    /**
     * Add the student to the professor's student list.
     * This action also add the course to the student.
     * @param student
     */
    public void AddStudent(Student student) {
        System.out.println("---------- Add student (professor) ----------");
        if(student.university.equals(this.university)) { // If student's university is equal to professor's university
            if(student.field != null) { // If student's field isn't null
                if(!studentList.contains(student)) { // If student list doesn't contain the student
                    studentList.add(student);
                    this.course.AddStudent(student); // Add student in the course
                    System.out.println(student + " added in " + this + "'s student list.");
                } else {
                    System.out.println(student + " already in " + this + "'s student list.");
                }
            } else {
                System.out.println(student + " need a field to have a professor.");
            }
        } else {
            System.out.println("The student isn't in the same university.");
        }
    }

    /**
     * Remove the student from the professor's student list.
     * @param student
     */
    public void RemoveStudent(Student student){
        System.out.println("---------- Remove student (professor) ----------");
        if (studentList.contains(student)) { // If student list contains the student
            studentList.remove(student); // Remove the student from the list
            System.out.println(student + " removed from " + this + "'s student list.");
        } else {
            System.out.println(student + " isn't in " + this + "'s student list.");
        }
    }


    /**
     * Convert professor to JSON syntax
     * @return str
     */
    public String toJSON(){
        String str = "\n\t\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + this.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + this.lastName + "\"," +
                "\n\t\t\t\"Function\" : \"" + this.function + "\"," +
                "\n\t\t\t\"Course\" : " + this.course + "," +
                "\n\t\t\t\"Student list\" : " + this.studentList + "\n\t\t\t}";
        return str;
    }
}