package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired StudentRepository sr;


    // Adding New Student
    public void addStudent(Student student){
        sr.addStudnet(student);
    }

    // Adding New Teacher
    public void addTeacher(Teacher teacher){
        sr.addTeacher(teacher);
    }

    //Fetching Student by Student Name
    public Student getStudent(String studentName){
        return sr.getStudent(studentName);
    }

    //Fetching Teacher by teacher Name
    public Teacher getTeacher(String teacherName){
        return sr.getTeacher(teacherName);
    }

    // Pair Student and Teacher
    public void piarStudentandTeacher(String teacherName, String studentName){
        sr.pairStudentandTeacher(teacherName,studentName);
    }

    // Fetching Student List by Teacher Name
    public ArrayList<String> studentByTeacher(String teacherName){
        return sr.studentListbyTeacherName(teacherName);
    }


    //Fetching all Stundents
    public ArrayList<String> allStudents(){
        return  sr.allStudents();
    }

    //Delete Teacher and its Stundets by Teacher Name
    public void deleteTeacher(String teacherName){
        sr.deleteTeacher(teacherName);
    }

    //Delete all Teachers
    public void deleteAllTeachers(){
        sr.teachersAllDelete();
    }
}
