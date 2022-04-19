package ca.uqac.inf334;

import java.lang.String;
import java.util.HashSet;


/**
 * Field's class
 */
public class Field {
    String name;
    University university;
    HashSet<Course> coursesList = new HashSet<>();
    HashSet<Student> studentList = new HashSet<>();

    /**
     * Field's constructor
     * @param name field's name
     */
    public Field(String name){
        this.name = name;
        this.university = null;
    }


    /**
     * Set a university to the field.
     * The field can only have one university. If we set a university to a field which it already has one,
     * its attributes will be reset (course list and student list).
     * @param newUniversity field's new university
     */
    public void SetUniversity(University newUniversity){
        System.out.println("---------- Set university (field) ----------");
        if (this.university != newUniversity) { // If the field's university isn't equal to the new university
            if (this.university != null) { // If the field's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university); // Remove the university of the field
            }
            if (newUniversity != null) { // If the new university isn't null
                this.university = newUniversity;
                newUniversity.AddField(this); // Add the field to the new university
            }
        }
    }

    /**
     * Remove the university of the field.
     * This action also remove the field from the university's field list and alla the courses and students of the field.
     * @param university field's university
     */
    public void RemoveUniversity(University university){
        System.out.println("---------- Remove university (field) ----------");
        if (this.university != null) { // If the field's university is equal to the university
            this.university = null;
            System.out.println(this + " field has no longer university.");
            university.RemoveField(this); // Remove the field from the university
            for (Course course: coursesList){ // Remove all the courses of the field
                this.RemoveCourse(course);
            }
            for (Student student: studentList){ // Remove all the students of the field
                this.RemoveStudent(student);
            }
        } else {
            System.out.println(this + " field isn't in the university.");
        }
    }


    /**
     * Add a course in the field.
     * This action also add the field to the course.
     * @param course field's course
     */
    public void AddCourse(Course course){
        System.out.println("---------- Add course (field) ----------");
        if (this.university.equals(course.university)) { // If the field's university is equal to the course's university
            if (!coursesList.contains(course)) { // If the course list doesn't contain the course
                coursesList.add(course); // Add the course to the list
                System.out.println(course + " is now in this field.");
                course.AddField(this); // Add the field to the course.
            } else {
                System.out.println(course + " already exist in this field.");
            }
        } else {
            System.out.println("Not in the same university.");
        }
    }

    /**
     * Remove a course from the field.
     * This action also remove the field of the course.
     * @param course field's course
     */
    public void RemoveCourse(Course course){
        System.out.println("---------- Remove course (field) ----------");
        if (coursesList.contains(course)) { // If the course list contain the course
            coursesList.remove(course); // Remove the course from the list
            System.out.println(course + " removed from " + this + "'s courses list.");
            course.RemoveField(this); // Remove the field to the field list of the course
        } else {
            System.out.println(course + " doesn't exist in " + this + "'s courses list");
        }
    }


    /**
     * Add a student to the field.
     * The field's university and the student's university must be the same.
     * This action also set the field of the student.
     * @param student field's student
     */
    public void AddStudent(Student student){
        System.out.println("---------- Add student (field) ----------");
        if (this.university.equals(student.university)) { // If the field's university is equal to the student's university
            if (!studentList.contains(student)) { // If the student list contain the student
                studentList.add(student); // Add the student to the list
                System.out.println(student + " is now in this field.");
                student.SetField(this); // Set this field to the student
            } else {
                System.out.println(student + " is already in this field.");
            }
        }
    }

    /**
     * Remove a student from the field.
     * This action also remove the field of the student.
     * @param student field's student
     */
    public void RemoveStudent(Student student){
        System.out.println("---------- Remove student (field) ----------");
        if (studentList.contains(student)) { // If the student list contain the student
            studentList.remove(student); // Remove the student from the list
            System.out.println(student + " removed from " + this + "'s student list.");
            student.RemoveField(this); // Remove the field to the student
        } else {
            System.out.println(student + " doesn't exist in " + this + "'s student list.");
        }
    }


    /**
     * @return field name
     */
    public String toString(){
        return "\"" + this.name + "\"";
    }


    /**
     * Convert field to JSON syntax
     * @return str field's json syntax
     */
    public String toJSON(){
        String str = "\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + this.name + "\"," +
                "\n\t\t\t\"Courses list\" : " + this.coursesList + "," +
                "\n\t\t\t\"Student list\" : " + this.studentList + "\n\t\t}";
        return str;
    }
}