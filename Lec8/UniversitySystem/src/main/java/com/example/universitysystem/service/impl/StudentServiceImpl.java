package com.example.universitysystem.service.impl;

import com.example.universitysystem.model.Course;
import com.example.universitysystem.model.Student;
import com.example.universitysystem.repo.CourseRepo;
import com.example.universitysystem.repo.StudentRepo;
import com.example.universitysystem.service.CourseService;
import com.example.universitysystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepo.getById(id);
    }

    @Override
    public Student registerStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepo.getById(studentId);
        Course course = courseRepo.getById(courseId);
        student.getCourses().add(course);
        return studentRepo.save(student);
    }
}
