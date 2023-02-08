package com.springFirstProject.SpringBoot;

import com.springFirstProject.SpringBoot.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringBootLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearnApplication.class, args);
	}

	/*@GetMapping(path = "/home")
	public List<Student> student() {
		return List.of(
				new Student(1l,24,"Akash","Akash123@gmail.com", LocalDate.of(1998,5,22))
		);
	}*/
}
