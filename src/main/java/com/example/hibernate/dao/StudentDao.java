package com.example.hibernate.dao;

import com.example.hibernate.model.Student;
import com.example.hibernate.util.HibernateConnectionConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import com.mysql.cj.Session;

public class StudentDao {
    private Session session;
    public StudentDao(){
        session = HibernateConnectionConfig.getSessionFactory().openSession();
    }
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
}
