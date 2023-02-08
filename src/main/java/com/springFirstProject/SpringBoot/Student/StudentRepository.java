package com.springFirstProject.SpringBoot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

/*
This is the data access layer which will fetch the data from the database
 */

@Repository
public interface StudentRepository extends
        JpaRepository<Student,Long> {

    //SELECT * from student where email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);


}
