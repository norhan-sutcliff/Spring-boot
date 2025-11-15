package com.example.universitysystem.controller;

import com.example.universitysystem.model.Student;
import com.example.universitysystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student/id")
    public Student getStudentById(@RequestParam Long id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/student/course")
    public Student registerStudentToCourse(@RequestParam Long studentId,@RequestParam Long courseId){
        return studentService.registerStudentToCourse(studentId,courseId);
    }


}
