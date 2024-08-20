package com.console.university_console.util.mappers;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.model.Department;

public class DepartmentMapper {
    public static Department fromDto(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setName(departmentDto.getName());
        department.setSalary(departmentDto.getSalary());
        return department;
    }

    public static DepartmentDto toDto(Department department) {
        return DepartmentDto
                .builder()
                .departmentId(department.getDepartmentId())
                .name(department.getName())
                .head_of_department_id(department.getHead_of_department().getLectorId())
                .salary(department.getSalary())
                .build();
    }
}
