package ca.uqac.inf334;

import java.util.HashSet;
import java.util.Iterator;

/**
 * University's class
 */
public class University {
    String name;
    HashSet<Staff> adminList = new HashSet<>();
    HashSet<Staff> secretaryList = new HashSet<>();
    HashSet<Professor> professorList = new HashSet<>();
    HashSet<Student> studentList = new HashSet<>();
    HashSet<Room> roomList = new HashSet<>();
    HashSet<Course> coursesList = new HashSet<>();
    HashSet<Field> fieldList = new HashSet<>();
    HashSet<Sport> sportList = new HashSet<>();


    /**
     * University's Constructor
     * @param name University's name
     */
    public University(String name) {
        this.name = name;
    }


    /**
     * Add an admin to the university's admin list.
     * This action also set an University to the admin.
     * @param admin University's admin
     */
    public void AddAdmin(Admin admin){
        System.out.println("---------- Add admin ----------");
        if (!adminList.contains(admin)) { // If admin list doesn't contain the admin
            adminList.add(admin); // Add admin to the list
            System.out.println(admin + " is now an admin of " + this);
            admin.SetUniversity(this); // Set this university to the admin
        } else {
            System.out.println(admin + " is already an admin of " + this);
        }
    }

    /**
     * Remove an admin from the university's admin list.
     * This action also remove the University of the admin.
     * @param admin University's admin
     */
    public void RemoveAdmin(Admin admin){
        System.out.println("---------- Remove admin ----------");
        if (adminList.contains(admin)) { // If admin list contain the admin
            adminList.remove(admin); // Remove the admin from the list
            System.out.println(admin + " removed from " + this + "'s admin list.");
            admin.RemoveUniversity(this); // Remove the university of the admin
        } else {
            System.out.println(admin + " doesn't exist in " + this + "'s admin list.");
        }
    }


    /**
     * Add a secretary to the university's secretary list.
     * This action also add the University of the secretary.
     * @param secretary University's secretary
     */
    public void AddSecretary(Secretary secretary){
        System.out.println("---------- Add secretary ----------");
        if(!secretaryList.contains(secretary)){ // If secretary list doesn't contain the secretary
            secretaryList.add(secretary); // Add secretary to the list
            System.out.println(secretary + " is now a secretary of " + this);
            secretary.SetUniversity(this); // Set this university to the secretary
        } else {
            System.out.println(secretary + " is already a secretary of " + this);
        }
    }

    /**
     * Remove a secretary from the university's secretary list.
     * This action also remove the University of the secretary.
     * @param secretary University's secretary
     */
    public void RemoveSecretary(Secretary secretary){
        System.out.println("---------- Remove secretary ----------");
        if (secretaryList.contains(secretary)) { // If secretary list contains the secretary
            secretaryList.remove(secretary); // Remove the secretary from the list
            System.out.println(secretary + " removed from " + this + "'s secretary list.");
            secretary.RemoveUniversity(this); // Remove the university of the secretary
        } else {
            System.out.println(secretary + " doesn't exist in " + this + "'s secretary list.");
        }
    }


    /**
     * Add a professor to the university's professor list.
     * This action also add the University of the professor.
     * @param professor University's professor
     */
    public void AddProfessor(Professor professor){
        System.out.println("---------- Add professor ----------");
        if (!professorList.contains(professor)) { // If professor list doesn't contain the professor
            professorList.add(professor); // Add the professor to the list
            System.out.println(professor + " is now a professor of " + this);
            professor.SetUniversity(this); // Set this university to the professor
        } else {
            System.out.println(professor + " is already a professor of " + this);
        }
    }

    /**
     * Remove a professor from the university's professor list.
     * This action also remove the University of the professor.
     * @param professor University's professor
     */
    public void RemoveProfessor(Professor professor){
        System.out.println("---------- Remove professor ----------");
        if (professorList.contains(professor)) { // If professor list contain the professor
            professorList.remove(professor); // Remove the professor from the list
            System.out.println(professor + " removed from " + this + "'s professor list.");
            professor.RemoveUniversity(this); // Remove the university of the professor
        } else {
            System.out.println(professor + " doesn't exist in " + this + "'s professor list.");
        }
    }


    /**
     * Add a room to the university's room list.
     * @param room University's room
     */
    public void AddRoom(Room room){
        System.out.println("---------- Add room ----------");
        if (!roomList.contains(room)) { // If room list doesn't contain the room
            roomList.add(room); // Add the room to the list
            System.out.println(room + " is now a room of " + this);
        } else {
            System.out.println(room + " is already a room of " + this);
        }
    }

    /**
     * Remove a room from the university's room list.
     * @param room University's room
     */
    public void RemoveRoom(Room room){
        System.out.println("---------- Remove room ----------");
        if (roomList.contains(room)) { // If room list contain the room
            roomList.remove(room); // Remove the room from the list
            System.out.println(room + " removed from " + this + "'s room list.");
        } else {
            System.out.println(room + " doesn't exist in " + this + "'s room list.");
        }
    }


    /**
     * Add a student to the university's student list.
     * This action also add University of the Student.
     * @param student University's student
     */
    public void AddStudent(Student student){
        System.out.println("---------- Add student ----------");
        if (!studentList.contains(student)) { // If student list doesn't contain the student
            studentList.add(student); // Add the student to the list
            System.out.println(student + " is now a student of " + this);
            student.SetUniversity(this); // Set this university to the student
        } else {
            System.out.println(student + " is already a student of " + this);
        }
    }

    /**
     * Remove a student from the university's student list.
     * This action also remove University of the Student.
     * @param student University's student
     */
    public void RemoveStudent(Student student){
        System.out.println("---------- Remove student ----------");
        if (studentList.contains(student)) { // If student list doesn't contain the student
            studentList.remove(student); // Remove the student from the list
            System.out.println(student + " removed from " + this + "'s student list.");
            student.RemoveUniversity(this); // Remove the university of the student
        } else{
            System.out.println(student + " doesn't exist in " + this + "'s student list.");
        }
    }


    /**
     * Add course to the university's course list.
     * This action also add University of the course.
     * @param course University's course
     */
    public void AddCourse(Course course){
        System.out.println("---------- Add course ----------");
        if (!coursesList.contains(course)) { // If courses list contain the course
            coursesList.add(course); // Add the course to the list
            System.out.println(course + " is now a course of " +  this);
            course.SetUniversity(this); // Set this university to the course
        } else{
            System.out.println(course + " is already a course of " + this);
        }
    }

    /**
     * Remove course from the university's course list.
     * This action also remove University of the course.
     * @param course University's course
     */
    public void RemoveCourse(Course course){
        System.out.println("---------- Remove course ----------");
        if (coursesList.contains(course)) { // If the course list doesn't contain the student
            coursesList.remove(course); // Remove the course from the list
            System.out.println(course + " removed from " + this + "'s course list.");
            course.RemoveUniversity(this); // Remove this university to the course
        } else {
            System.out.println(course + " doesn't exist in " + this + "'s course list.");
        }
    }


    /**
     * Add field to the university's field list.
     * This action also add University of the field.
     * @param field University's field
     */
    public void AddField(Field field){
        System.out.println("---------- Add field ----------");
        if (!fieldList.contains(field)) { // If the field list doesn't contain the field
            fieldList.add(field); // Add the field to the list
            System.out.println(field + " is now a field of " + this);
            field.SetUniversity(this); // Set this university to the field
        } else{
            System.out.println(field + " is already a field of " + this);
        }
    }

    /**
     * Remove field from the university's field list.
     * This action also remove University of the field.
     * @param field University's field
     */
    public void RemoveField(Field field){
        System.out.println("---------- Remove field ----------");
        if (fieldList.contains(field)) { // If the field list contain the field
            fieldList.remove(field); // Remove the field from the list
            System.out.println(field + " removed from " + this + "'s field list.");
            field.RemoveUniversity(this); // Remove this university to the field
        } else{
            System.out.println(field + " doesn't exist in " + this + "'s field list.");
        }
    }


    /**
     * Add sport to the university's sport list.
     * This action also add University of the sport
     * @param sport University's sport
     */
    public void AddSport(Sport sport){
        System.out.println("---------- Add sport ----------");
        if (!sportList.contains(sport)) { // If the sport list doesn't contain the sport
            sportList.add(sport); // Add the sport to the list
            System.out.println(sport + " is now a sport of " + this);
        } else{
            System.out.println(sport + " is already a sport of " + this);
        }
    }

    /**
     * Remove sport from the university's sport list.
     * This action also remove university of the sport.
     * @param sport University's sport
     */
    public void RemoveSport(Sport sport){
        System.out.println("---------- Remove sport ----------");
        if (sportList.contains(sport)) { // If the sport list contain the sport
            sportList.remove(sport); // Remove the sport from the list
            System.out.println(sport + " removed from " + this + "'s sport list.");
            for (Student student: sport.studentList){
                sport.RemoveStudent(student);
            }
        } else {
            System.out.println(sport + " doesn't exist in " + this + "'s sport list.");
        }
    }


    /**
     * Return name of University
     * @return University's name
     */
    public String toString(){
        return this.name;
    }


    /**
     * Convert University to JSON syntax
     * @return string for University's json syntax
     */
    public String toJSON(){
        /*
         * String to print university
         */
        String strUniversity = "{\n\"" + this + "\": {\n\t" +
                "\"Name\" : \"" + this.name + "\",";

        /*
         * String to print administrators
         */
        StringBuilder strAdmin = new StringBuilder();
        Staff lastAdmin = null;
        Iterator<Staff> itAdmin = adminList.iterator();
        while(itAdmin.hasNext()){
            lastAdmin = itAdmin.next();
        }
        for (Staff admin: adminList) {
            if(admin.equals(lastAdmin)) {
                strAdmin.append(admin.toJSON());
            } else{
                strAdmin.append(admin.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Administrators\" : [" + strAdmin + "\n\t],";

        /*
         * String to print secretaries
         */
        StringBuilder strSecretary = new StringBuilder();
        Staff lastSecretary = null;
        Iterator<Staff> itSecretary = secretaryList.iterator();
        while(itSecretary.hasNext()){
            lastSecretary = itSecretary.next();
        }
        for (Staff secretary: secretaryList) {
            if(secretary.equals(lastSecretary)){
                strSecretary.append(secretary.toJSON());
            } else{
                strSecretary.append(secretary.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Secretaries\" : [" + strSecretary + "\n\t],";

        /*
         * String to print professors
         */
        StringBuilder strProfessor = new StringBuilder();
        Professor lastProfessor = null;
        Iterator<Professor> itProfessor = professorList.iterator();
        while(itProfessor.hasNext()){
            lastProfessor = itProfessor.next();
        }
        for (Professor professor: professorList) {
            if(professor.equals(lastProfessor)){
                strProfessor.append(professor.toJSON());
            } else{
                strProfessor.append(professor.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Professors\" : [" + strProfessor + "\n\t],";

        /*
         * String to print students
         */
        StringBuilder strStudent = new StringBuilder();
        Student lastStudent = null;
        Iterator<Student> itStudent = studentList.iterator();
        while(itStudent.hasNext()){
            lastStudent = itStudent.next();
        }
        for (Student student: studentList) {
            if(student.equals(lastStudent)){
                strStudent.append(student.toJSON());
            } else{
                strStudent.append(student.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Students\" : [" + strStudent + "\n\t],";

        /*
         * String to print fields
         */
        StringBuilder strField = new StringBuilder();
        Field lastField = null;
        Iterator<Field> itField = fieldList.iterator();
        while(itField.hasNext()){
            lastField = itField.next();
        }
        for (Field field: fieldList) {
            if(field.equals(lastField)){
                strField.append(field.toJSON());
            } else{
                strField.append(field.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Fields\" : [" + strField + "\n\t],";

        /*
         * String to print courses
         */
        StringBuilder strCourse = new StringBuilder();
        Course lastCourse = null;
        Iterator<Course> itCourse = coursesList.iterator();
        while(itCourse.hasNext()){
            lastCourse = itCourse.next();
        }
        for (Course course: coursesList) {
            if(course.equals(lastCourse)){
                strCourse.append(course.toJSON());
            } else{
                strCourse.append(course.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Courses\" : [" + strCourse + "\n\t],";

        /*
         * String to print rooms
         */
        StringBuilder strRoom = new StringBuilder();
        Room lastRoom = null;
        Iterator<Room> itRoom = roomList.iterator();
        while(itRoom.hasNext()){
            lastRoom = itRoom.next();
        }
        for (Room room: roomList) {
            if(room.equals(lastRoom)){
                strRoom.append(room.toJSON());
            } else{
                strRoom.append(room.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Rooms\" : [" + strRoom + "\n\t],";

        /*
         * String to print sports
         */
        StringBuilder strSport = new StringBuilder("");
        Sport lastSport = null;
        Iterator<Sport> itSport = sportList.iterator();
        while(itSport.hasNext()){
            lastSport = itSport.next();
        }
        for (Sport sport: sportList) {
            if(sport.equals(lastSport)){
                strSport.append(sport.toJSON());
            } else{
                strSport.append(sport.toJSON()).append(",");
            }
        }
        strUniversity += "\n\t\"Sports\" : [" + strSport + "\n\t]";

        strUniversity += "\n}\n}";

        return strUniversity;
    }
}