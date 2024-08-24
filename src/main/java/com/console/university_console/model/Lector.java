package com.console.university_console.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String lectorId;

    private String firstname;

    private String lastname;

    private String degree;

    @OneToOne(mappedBy = "headOfDepartment")
    @JsonBackReference(value = "department-head")
    private Department headingDepartment;

    @ManyToMany(mappedBy = "departmentEmployees")
//    @JsonBackReference(value = "department-employees")
    private List<Department> workOnDepartments;
}
