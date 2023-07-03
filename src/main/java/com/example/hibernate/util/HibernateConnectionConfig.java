package com.example.hibernate.util;

import com.example.hibernate.model.Student;
import com.mysql.cj.Session;
import org.hibernate.SessionFactory;

//import javax.security.auth.login.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

//import javax.imageio.spi.ServiceRegistry;
import java.util.Properties;

public class HibernateConnectionConfig {
    private static SessionFactory sessionFactory;


    private HibernateConnectionConfig() {

    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml properties

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/tempdb?userSSL=false");
                settings.put(Environment.USER,"test");
                settings.put(Environment.PASS,"password123!");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL,"true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
                settings.put(Environment.HBM2DDL_AUTO,"create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Student.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                                                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
