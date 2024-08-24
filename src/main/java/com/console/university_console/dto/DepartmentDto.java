package com.console.university_console.dto;

import com.console.university_console.model.Lector;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DepartmentDto {
    private String departmentId;

    @Min(value = 0, message = "salary field cannot be less than 0")
    @NotNull(message = "salary cannot be empty")
    private Integer salary;

    @Size(min = 2, max = 36, message = "department length cannot be less than 2 and higher than 36 characters")
    @NotBlank(message = "department cannot be blank")
    private String name;

    @NotBlank(message = "headOfDepartmentId field cannot be empty")
    private String headOfDepartmentId;

//    @NotBlank(message = "head_of_department field cannot be empty")

    private Lector headOfDepartment;

    private List<Lector> departmentEmployees;

}
