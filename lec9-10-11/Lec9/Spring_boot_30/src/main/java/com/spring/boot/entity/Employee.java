package com.spring.boot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Integer salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();



}
