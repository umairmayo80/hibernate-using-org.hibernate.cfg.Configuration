package com.example.hibernate;

import com.example.hibernate.dao.StudentDao;
import com.example.hibernate.model.Student;

public class App {
    public static void main(String[] args){
        StudentDao studentDao = new StudentDao();

        Student student = new Student("Ali","Umer","Ali@umer.com");
        studentDao.saveStudent(student);

        System.out.println(student.getId());

    }
}
