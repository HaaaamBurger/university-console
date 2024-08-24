package com.console.university_console.util.mappers;

import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Department;
import com.console.university_console.model.Lector;

import java.util.List;


public class LectorMapper {

    public static Lector fromDto(LectorDto lectorDto) {
        Lector lector = new Lector();
        lector.setLectorId(lectorDto.getLectorId());
        lector.setFirstname(lectorDto.getFirstname());
        lector.setDegree(lectorDto.getDegree());
        lector.setLastname(lectorDto.getLastname());
        lector.setHeadingDepartment(lector.getHeadingDepartment());
        lector.setWorkOnDepartments(lectorDto.getWorkOnDepartments());
//        lector.setHeadingDepartments(headingDepartments);

        return lector;
    }

    public static LectorDto toDto(Lector lector) {
        return LectorDto
                .builder()
                .lectorId(lector.getLectorId())
                .firstname(lector.getFirstname())
                .degree(lector.getDegree())
                .lastname(lector.getLastname())
                .headingDepartment(lector.getHeadingDepartment())
                .workOnDepartments(lector.getWorkOnDepartments())
//                .headingDepartments_ids(lector.getHeadingDepartments().stream().map(Department::getDepartmentId).toList())
                .build();
    }
}
