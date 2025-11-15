package com.example.universitysystem.service;

import com.example.universitysystem.model.Student;

import java.util.List;

public interface StudentService {

    public Student addStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public Student registerStudentToCourse(Long studentId,Long courseId);
}
