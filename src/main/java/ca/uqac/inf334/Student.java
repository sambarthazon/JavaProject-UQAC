package ca.uqac.inf334;

import java.util.HashSet;

/**
 * Student's class
 */
public class Student {
    String lastName;
    String firstName;
    String birthday;
    University university;
    String permanentCode;
    Field field;
    HashSet<Course> coursesList = new HashSet<>();
    HashSet<Sport> sportList = new HashSet<>();

    /**
     * Student's Constructor
     * @param lastName Student's last name
     * @param firstName Student's firstname
     * @param birthday Student's birthday
     */
    public Student(String lastName, String firstName, String birthday){
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.university = null;
        this.permanentCode = PermanentCode();
        this.field = null;
    }


    /**
     * Set university to the student
     * This action also add the student to the university's student list. If we set a university to a student which it already has one,
     * its attributes will be reset.
     * @param newUniversity Student's university
     */
    public void SetUniversity(University newUniversity){
        System.out.println("---------- Set university (student) ----------");
        if (this.university != newUniversity) { // If student's university isn't equal to the new university
            if (this.university != null) { // If student's university isn't null
                final University oldUniversity = this.university;
                this.RemoveUniversity(this.university); // Remove the university of the student
            }
            if (newUniversity != null) {
                this.university = newUniversity;
                newUniversity.AddStudent(this); // Add the student to the university
            }
        }
    }

    /**
     * Remove the university of the student
     * This action also remove the Student from the University's Student list and delete field and all his sports.
     * @param university Student's university
     */
    public void RemoveUniversity(University university){
        System.out.println("---------- Remove university (student) ----------");
        if (this.university != null) { // If student's university isn't null
            this.university = null;
            System.out.println(this + " has no longer university.\n");
            university.RemoveStudent(this); // Remove student from the university
            this.RemoveField(this.field); // Remove the field of the student
            for (Sport sport: sportList) { // Remove all sports
                this.RemoveSport(sport);
            }
        } else {
            System.out.println(this + " isn't in this university.\n");
        }
    }


    /**
     * Generate a permanent code
     * @return Student's permanentCode
     */
    public String PermanentCode() {
        System.out.println("---------- Permanent code (student) ----------");
        int n = (int)(Math.random() * 10); // random number
        String str_n = String.valueOf(n); // int into string
        int n1 = (int)(Math.random() * 10); // random number
        String str_n1 = String.valueOf(n1); // int into String
        // Creation of the permanent code
        String permanentCode = lastName.substring(0, 3)+firstName.substring(0,1)+
                birthday.substring(0,2)+birthday.substring(3,5)+birthday.substring(6,8)+
                str_n+str_n1;
        this.permanentCode = permanentCode;
        System.out.println("Permanent code : " + permanentCode + " belongs to " + this.firstName); // Output
        return permanentCode;
    }


    /**
     * Add a field to the student
     * This action also remove all his course.
     * @param newField Student's Field
     */
    public void SetField(Field newField){
        System.out.println("---------- Set field (student) ----------");
        if (this.field != newField) { // If student's field isn't equal to the new field
            if (this.field != null) { // If student's field isn't null
                final Field oldField = this.field;
                this.RemoveField(this.field); // Remove the student from the field
            }
            if (newField != null) { // If the new field isn't null
                this.field = newField;
                newField.AddStudent(this); // Add the student to the new field
            }
        }
    }

    /**
     * Remove the student's field
     * This action also remove field from the student and all his course.
     * @param field Student's field
     */
    public void RemoveField(Field field){
        System.out.println("---------- Remove field (student) ----------");
        if (this.field != null) { // If student's field isn't null
            this.field = null;
            System.out.println(this + " has no longer field.");
            for (Course course: coursesList) {
                this.RemoveCourse(course); // Remove all courses
            }
            field.RemoveStudent(this); // Remove student from the field
        } else {
            System.out.println(this + " isn't in this field.");
        }
    }


    /**
     * Add a course to the student's courses list.
     * This action also verify if the field has the course and it add the student to course's student list.
     * @param course Student's course
     */
    public void AddCourse(Course course) {
        System.out.println("---------- Add course (student) ----------");
        if (this.field != null) { // If the student's field isn't null
            if (field.coursesList.contains(course)) { // If the field's courses list contain the course
                if (!coursesList.contains(course)) { // If the course list doesn't contain
                    coursesList.add(course); // Add the course to the list
                    System.out.println(course + " is now a course of " + this);
                    course.AddStudent(this);
                } else {
                    System.out.println(course + " is already a course of " + this);
                }
            } else {
                System.out.println(course + " isn't available in the field of " + this);
            }
        } else {
            System.out.println(this + " student need a field to add a course.\n");
        }
    }

    /**
     * Remove a course from the student's courses list.
     * This action also remove Student of the course.
     * @param course Student's course
     */
    public void RemoveCourse(Course course){
        System.out.println("---------- Remove course (student) ----------");
        if (coursesList.contains(course)) { // If the course list contain the course
            coursesList.remove(course); // Remove the course from the list
            System.out.println(course + " removed from " + this + "'s course list.");
            course.RemoveStudent(this); // Remove the student from the course
        } else {
            System.out.println(course + " doesn't exist in " + this + "'s course list.");
        }
    }


    /**
     * Add a sport to the student.
     * This action also add student of the sport.
     * @param sport Student's sport
     */
    public void AddSport(Sport sport){
        System.out.println("---------- Add sport (student) ----------");
        if (!sportList.contains(sport)) { // If the sport list doesn't contain the sport
            sportList.add(sport); // Add the sport to the list
            System.out.println(sport + " is now a sport of " + this);
            sport.AddStudent(this); // Add the student to the sport
        } else {
            System.out.println(sport + " is already a sport of " + this);
        }
    }

    /**
     * Remove the student's sport.
     * This action also remove student of the sport.
     * @param sport Student's sport
     */
    public void RemoveSport(Sport sport){
        System.out.println("---------- Remove sport (student) ----------");
        if (sportList.contains(sport)) { // If the sport list contain the sport
            sportList.remove(sport); // Remove the sport from the list
            sport.RemoveStudent(this); // Remove the student from the sport
            System.out.println(sport + " removed from " + this + "'s sport list.");
        } else {
            System.out.println(sport + " doesn't exist in " + this + "'s sport list.");
        }
    }


    /**
     * Return Student toString
     * @return student's first name and Student's last name
     */
    public String toString(){
        return "\"" + this.firstName + " " + this.lastName + "\"";
    }


    /**
     * Convert Student to JSON syntax
     * @return string for Student's json syntax
     */
    public String toJSON(){
        String str = "\n\t\t{" +
                "\n\t\t\t\"Firstname\" : \"" + this.firstName + "\"," +
                "\n\t\t\t\"Lastname\" : \"" + this.lastName + "\"," +
                "\n\t\t\t\"Birthday\" : \"" + this.birthday + "\"," +
                "\n\t\t\t\"Permanent Code\" : \"" + this.permanentCode + "\"," +
                "\n\t\t\t\"Field\" : " + this.field + "," +
                "\n\t\t\t\"Courses list\" : " + this.coursesList + "," +
                "\n\t\t\t\"Sport list\" : " + this.sportList + "\n\t\t}";
        return str;
    }
}