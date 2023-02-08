package com.springFirstProject.SpringBoot.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return i -> {
            Student Akash = new Student(1l,
                    "Akash",
                    "Akash123@gmail.com",
                    LocalDate.of(1995,5,22));
            Student Kunal = new Student(2l,
                    "Kunal",
                    "kardakunal@gmail.com",
                    LocalDate.of(1998,5,15));
            Student Aditeya = new Student(3l,
                    "Aditeya",
                    "aditeya224@gmail.com",
                    LocalDate.of(2000,7,24));
            repository.saveAll(
                    List.of(Akash,Kunal,Aditeya));

        };
    }
}
