package com.console.university_console.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String departmentId;

    @Min(value = 0, message = "salary field cannot be less than 0")
    private Integer salary;

    @Size(min = 2, max = 36, message = "department length cannot be less than 2 and higher than 36 characters")
    @NotBlank(message = "department cannot be blank")
    private String name;

    @ManyToOne
    @JoinColumn(name = "lectorId")
    @NotNull(message = "head_of_department field cannot be empty")
    private Lector head_of_department;
}
