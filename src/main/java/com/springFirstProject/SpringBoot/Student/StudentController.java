package com.springFirstProject.SpringBoot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/l1/getdata")
public class StudentController {




    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getListOfStudents() {
        return studentService.getStudent();
    }

    @PostMapping
    public void NewStudent(@RequestBody Student student) { // here we are requesting the body and then mapping it to students
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = {"studentId"})
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

}
