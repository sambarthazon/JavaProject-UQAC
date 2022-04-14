package ca.uqac.inf334;

import java.util.*;

public class Sport {
    String name;
    University university;
    HashSet<Student> studentList = new HashSet<>();

    /**
     * Sport's Constructor
     * @param name
     * @param university
     */
    public Sport(String name, University university){
        this.name = name;
        this.university = university;
        university.AddSport(this);
    }


    /**
     * Add student to the sport student's list.
     * This action also add sport to the student.
     * @param student
     */
    public void AddStudent(Student student){
        System.out.println("---------- Add student (sport) ----------");
        if (!studentList.contains(student)) { // If the student list doesn't contain the student
            studentList.add(student); // Add the student to the list
            System.out.println(student + " is now in this sport.");
            student.AddSport(this); // Add the sport to the student
        } else{
            System.out.println(student + " doesn't practice this sport.");
        }
    }

    /**
     * Remove student to the sport student's list.
     * This action also remove sport to the student.
     * @param student
     */
    public void RemoveStudent(Student student){
        System.out.println("---------- Remove student (sport) ----------");
        if (studentList.contains(student)) { // If the student list contain the student
            studentList.remove(student); // Remove the student from the list
            System.out.println(student + " removed from this sport.");
            student.RemoveSport(this); // Remove the sport to the student
        } else {
            System.out.println(student + " doesn't practice this sport.");
        }
    }


    /**
     * Return sport toString
     * @return this.name
     */
    public String toString(){
        return "\"" + this.name + "\"";
    }


    /**
     * Convert Sport to JSON syntax
     * @return str
     */
    public String toJSON(){
        String str = "\n\t\t{" +
                "\n\t\t\t\"Name\" : \"" + this.name + "\"," +
                "\n\t\t\t\"Student list\" : " + this.studentList + "\n\t\t}";
        return str;
    }
}