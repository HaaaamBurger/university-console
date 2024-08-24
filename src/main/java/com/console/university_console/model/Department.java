package com.console.university_console.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    private String headOfDepartmentId;

    @OneToOne
    @JoinColumn(name = "head_of_department")
//    @JsonManagedReference(value = "department-employees")
    private Lector headOfDepartment;

    @ManyToMany
    @JoinTable(
            name = "department_lectors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id")
    )
//    @JsonManagedReference
    private List<Lector> departmentEmployees;
}
