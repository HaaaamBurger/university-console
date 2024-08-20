package com.console.university_console.dto;

import com.console.university_console.model.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LectorDto {
    private String lectorId;

    @Size(min = 2, max = 22, message = "firstname length cannot be less than 2 and higher than 22 characters")
    @NotBlank(message = "firstname field cannot be blank")
    private String firstname;

    @Size(min = 2, max = 22, message = "lastname length cannot be less than 2 and higher than 22 characters")
    @NotBlank(message = "lastname field cannot be blank")
    private String lastname;

    private List<String> headingDepartments_ids;
}
