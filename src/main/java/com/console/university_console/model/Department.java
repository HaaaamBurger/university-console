package com.console.university_console.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String departmentId;

    private Integer salary;

    private String name;

    @ManyToOne
    @JoinColumn(name = "head_of_department")
    private Lector head_of_department;
}
