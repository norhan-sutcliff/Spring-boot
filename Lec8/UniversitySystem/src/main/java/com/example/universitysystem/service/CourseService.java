package com.example.universitysystem.service;

import com.example.universitysystem.model.Course;

import java.util.List;

public interface CourseService {
    public Course addCourse(Course course);
    public List<Course> getAllCourses();
    public void assignInstructorToCourse(Long courseId,Long instructorId);
}
