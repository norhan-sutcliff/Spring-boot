package com.example.universitysystem.controller;
import com.example.universitysystem.model.Course;
import com.example.universitysystem.model.Instructor;
import com.example.universitysystem.service.InstructorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstructorController {
    private InstructorService instructorService;
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping("/instructor")
    public Instructor CreateInstructor(Instructor instructor){
        return instructorService.addInstructor(instructor);
    }
    @GetMapping("/instructor/all")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }
    @GetMapping("/instructor/course")
    public List<Course> getCourseByInstructorId(Long id){
        return instructorService.getCourseByInstructor(id);
    }
}
