package com.example.universitysystem.service.impl;
import com.example.universitysystem.model.Course;
import com.example.universitysystem.model.Instructor;
import com.example.universitysystem.repo.InstructorRepo;
import com.example.universitysystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepo instructorRepo;
    @Autowired
    public InstructorServiceImpl(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public List<Course> getCourseByInstructor(Long id) {
        Instructor instructor = instructorRepo.getById(id);
        return instructor.getCourses();
    }
}
