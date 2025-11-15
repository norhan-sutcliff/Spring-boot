package com.example.universitysystem.service.impl;
import com.example.universitysystem.model.Course;
import com.example.universitysystem.model.Instructor;
import com.example.universitysystem.repo.CourseRepo;
import com.example.universitysystem.repo.InstructorRepo;
import com.example.universitysystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;
    private InstructorRepo instructorRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo,InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long instructorId) {
        Instructor instructor = instructorRepo.getById(instructorId);
        Course course = courseRepo.getById(courseId);
        course.setInstructor(instructor);
        courseRepo.save(course);

    }
}
