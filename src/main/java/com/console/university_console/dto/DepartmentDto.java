package com.console.university_console.dto;

import com.console.university_console.model.Lector;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DepartmentDto {
    private String departmentId;

    private Integer salary;

    private String name;

    private Lector head_of_department;
}
