package com.console.university_console.model;

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

    @OneToMany(mappedBy = "head_of_department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Department> headingDepartments;


}
