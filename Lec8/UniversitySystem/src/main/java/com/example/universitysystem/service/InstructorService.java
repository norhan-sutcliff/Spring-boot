package com.example.universitysystem.service;

import com.example.universitysystem.model.Course;
import com.example.universitysystem.model.Instructor;
import com.example.universitysystem.repo.InstructorRepo;

import java.util.List;

public interface InstructorService {
    public Instructor addInstructor(Instructor instructor);
    public List<Instructor> getAllInstructors();
    public List<Course> getCourseByInstructor(Long id);

}
