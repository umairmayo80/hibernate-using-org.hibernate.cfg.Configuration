package com.example.hibernate.dao;

import com.example.hibernate.model.Student;
import com.example.hibernate.util.HibernateConnectionConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
//import com.mysql.cj.Session;

public class StudentDao {
    private final Session session;
    public StudentDao(){
        session = HibernateConnectionConfig.getSessionFactory().openSession();
    }

    // save Student object to database
    public void saveStudent(Student student){
        Transaction transaction = null;
        try{
        // start the transaction
        transaction =  session.beginTransaction();

        // save student object
        session.save(student);

        //commit transaction
        transaction.commit();
    } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }



    // Update Student
    public void updateStudent(Student student){
        Transaction transaction = null;
        try{
            // start the transaction
            transaction =  session.beginTransaction();

            // save student object
            session.saveOrUpdate(student);

            //commit transaction
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


    // get Student by Id
    public Student getStudentById(int id){
        Transaction transaction = null;
        Student student = null;
        try{
            // start the transaction
            transaction =  session.beginTransaction();

            // get student object
            student = session.get(Student.class,id);
            //Alternate way is to use load

            //commit transaction
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return student;
    }

    // get All Students
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents(){
        Transaction transaction = null;
        List<Student> studentList = null;
        try{
            // start the transaction
            transaction =  session.beginTransaction();

            // HQL
            studentList = session.createQuery("from Student").list();

            //commit transaction
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return studentList;
    }



    // delete Student by Id
    public void deleteStudentById(int id){
        Transaction transaction = null;
        Student student = null;
        try{
            // start the transaction
            transaction =  session.beginTransaction();

            // get student object
            student = session.get(Student.class,id);

            // now remove the student from database
            session.delete(student);

            //commit transaction
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }

    }



}
