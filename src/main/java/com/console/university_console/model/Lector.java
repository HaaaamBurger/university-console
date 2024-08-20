package com.console.university_console.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String lectorId;

    @Size(min = 2, max = 22, message = "firstname length cannot be less than 2 and higher than 22 characters")
    @NotBlank(message = "firstname field cannot be blank")
    private String firstname;

    @Size(min = 2, max = 22, message = "lastname length cannot be less than 2 and higher than 22 characters")
    @NotBlank(message = "lastname field cannot be blank")
    private String lastname;

    @OneToMany(mappedBy = "lectors")
    private List<Department> headingDepartments;
}
