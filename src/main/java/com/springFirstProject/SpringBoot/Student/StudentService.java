package com.springFirstProject.SpringBoot.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//We can also use @Component here but service is more professional and it defines what we are doing
@Service
public class StudentService {

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;



    public List<Student> getStudent() {
        return  /*List.of(
                new Student(1l,24,"Akash","Akash123@gmail.com", LocalDate.of(1998,5,22))
        );*/ studentRepository.findAll(); // Since we have added our data access layer with jpa respository which will automatically fetch the data
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
        System.out.println(
                student
        );
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with given id is not available");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with "+id+" does not exists"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)
        ) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)
        ) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("email Taken");
            }
            student.setEmail(email);
        }
    }
}
