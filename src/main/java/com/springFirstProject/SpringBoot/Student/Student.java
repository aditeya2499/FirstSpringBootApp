package com.springFirstProject.SpringBoot.Student;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Entity// Annonation to make a class as table
@Table
public class Student {

    @Id
    @SequenceGenerator(//generating a sequence
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    long id;

    @Transient//It says that there is no need for this attribute to be a seperate column in our database, we can calculate the age by dob
    int age;
    String name;
    String email;
    LocalDate dob;

    public Student() {
    }

    public Student( String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Student(long id,
                   String name,
                   String email,
                   LocalDate dob) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}
