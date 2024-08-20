package com.console.university_console.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartmentDto {
    private String departmentId;

    @Min(value = 0, message = "salary field cannot be less than 0")
    private Integer salary;

    @Size(min = 2, max = 36, message = "department length cannot be less than 2 and higher than 36 characters")
    @NotBlank(message = "department cannot be blank")
    private String name;

    @NotBlank(message = "head_of_department field cannot be empty")
    private String head_of_department_id;
}
