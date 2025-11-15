package com.example.universitysystem.controller;

import com.example.universitysystem.model.Course;
import com.example.universitysystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/course")
    public Course CreateCourse(@RequestParam  Course course)
    {
        return courseService.addCourse(course);
    }
    @GetMapping("/course/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/course/instructor")
    public void AssignInstructorToCourse(@RequestParam Long courseId,@RequestParam Long instructorId){
        courseService.assignInstructorToCourse(courseId,instructorId);
    }
}
