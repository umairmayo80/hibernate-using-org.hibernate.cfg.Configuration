package com.example.hibernate.model;
// model will contain all the entities

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity //Entity(name="student_details") it will change both entity name and table name, and we can also use the student_details name in HQL
@Table(name = "student") //only the table name will be updated to student
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    // if we don`t explicitly define the name, hibernate
    // will use the attribute name as the column name
    private String lastName;
    private String email;

    private int marks;

    public Student() {
        super();
    }

    public Student(int id, String firstName, String lastName, String email, int marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.marks = marks;
    }    public Student(String firstName, String lastName, String email, int marks) {
        id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", marks='" + marks + '\'' +
                '}';
    }
}
