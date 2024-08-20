package com.console.university_console.dto;

import com.console.university_console.model.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LectorDto {
    private String lectorId;

    private String firstname;

    private String lastname;

    private List<Department> headingDepartments;
}
