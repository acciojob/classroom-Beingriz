package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    // Creating Student Database Using HashMap
    HashMap<String, Student> student_db = new HashMap<>();
    // Creating Teacher Database
    HashMap<String, Teacher> teacher_db = new HashMap<>();
    //Creating Teacher and Student Paired Database
    HashMap<String, ArrayList<String>> teacher_student_db = new HashMap<>();

    //Adding New Student to Database
    public void addStudnet(Student student){
        student_db.put(student.getName(), student);
    }

    //Adding new Teacher to Teacher Database
    public void addTeacher(Teacher teacher){
        teacher_db.put(teacher.getName(), teacher);
    }

    //Retriving Student Using Stundet Name
    public Student getStudent(String studentName){
        return student_db.get(studentName);
    }

    //Retiving Teacher Using Teacher Name
    public Teacher getTeacher(String teacherName){
        return teacher_db.get(teacherName);
    }



    //Pair Student and Teacher by teacher name
    public void pairStudentandTeacher(String teacherName, String studentName){

        if(teacher_db.containsKey(teacherName) && student_db.containsKey(studentName)) {
            ArrayList<String> studentList = new ArrayList<>();
            if (teacher_student_db.containsKey(teacherName)) {
                // If Pair is Present
                studentList = teacher_student_db.get(teacherName);
            }
            // New List
            studentList.add(studentName);
            teacher_student_db.put(teacherName, studentList);
        }
    }

    // Display Student List by Teacher Name
    public ArrayList<String> studentListbyTeacherName(String teacherName){
        return teacher_student_db.get(teacherName);
    }

    //Fetching All Students
    public  ArrayList<String> allStudents(){
        ArrayList<String> students = new ArrayList<>();
        for (String name: student_db.keySet() ) {
            students.add(name);
        }
        return students;
    }

    //Delete Teacher by Teacher Name & its Students
    public void deleteTeacher(String teacherName){
        ArrayList<String> students = new ArrayList<>(teacher_student_db.get(teacherName));
        for (String name: students ) {
            student_db.remove(name);
        }
        teacher_db.remove(teacherName);
        teacher_student_db.remove(teacherName);

    }

    //Delete All teachers, It shuld Delete Teacher from Teacher DB, Teacher and Student DB and From Studnet DB
    public void teachersAllDelete (){
        for (String name: teacher_db.keySet()  ) {
            deleteTeacher(name);
        }
    }

}
