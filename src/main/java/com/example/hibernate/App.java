package com.example.hibernate;

import com.example.hibernate.dao.StudentDao;
import com.example.hibernate.model.Student;
import com.example.hibernate.util.HibernateConnectionConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args){
        StudentDao studentDao = new StudentDao();

        Student student = new Student("Ali","Umer","Ali@umer.com",89);
        studentDao.saveStudent(student);

        Student student1 = new Student("John","K","john@k.com",34);

        studentDao.saveStudent(student1);

        System.out.println(student1.getId());


        Student retrievedStudent = studentDao.getStudentById(student1.getId());
        System.out.println(retrievedStudent);


        List<Student> studentList = studentDao.getAllStudents();
        studentList.forEach(System.out::println);

        // delete student
        studentDao.deleteStudentById(student1.getId());

        System.out.println("Students after deletion");
        List<Student> studentList1 = studentDao.getAllStudents();
        studentList1.forEach(System.out::println);


        //
        studentDao.saveStudent(student1);


        // Testing HQL Queries
        // Delete, update, save requires transaction

        Session session = HibernateConnectionConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int targetId = 1;
        Query query = session.createQuery("delete from Student s where " +
                                            "s.id=:targetId"); // we can define placeholder using colon ":"
        query.setParameter("targetId",targetId);
        int rowsEffected = query.executeUpdate();
        System.out.println(rowsEffected);
        transaction.commit();
        session.close();

    }
}
