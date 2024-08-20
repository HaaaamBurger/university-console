package com.console.university_console.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String departmentId;

    private Integer salary;

    private String name;

    @ManyToOne
    @JoinColumn(name = "lector_id")
    private Lector head_of_department;
}
