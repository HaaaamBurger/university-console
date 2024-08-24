package com.console.university_console.util.mappers;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.model.Department;

public class DepartmentMapper {
    public static Department fromDto(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setName(departmentDto.getName());
        department.setHeadOfDepartment(departmentDto.getHeadOfDepartment());
        department.setHeadOfDepartmentId(departmentDto.getHeadOfDepartmentId());
        department.setDepartmentEmployees(departmentDto.getDepartmentEmployees());
        department.setSalary(departmentDto.getSalary());
        return department;
    }

    public static DepartmentDto toDto(Department department) {
        return DepartmentDto
                .builder()
                .departmentId(department.getDepartmentId())
                .headOfDepartmentId(department.getHeadOfDepartmentId())
                .name(department.getName())
                .departmentEmployees(department.getDepartmentEmployees())
                .headOfDepartment(department.getHeadOfDepartment())
                .salary(department.getSalary())
                .build();
    }
}
