package com.example.universitysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
