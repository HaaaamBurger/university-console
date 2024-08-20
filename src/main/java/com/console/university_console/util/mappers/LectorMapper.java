package com.console.university_console.util.mappers;

import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Lector;

public class LectorMapper {

    public static Lector fromDto(LectorDto lectorDto) {
        Lector lector = new Lector();
        lector.setLectorId(lector.getLectorId());
        lector.setFirstname(lector.getFirstname());
        lector.setLastname(lector.getLastname());
//        lector.setHeadingDepartments(lector.getHeadingDepartments());
        return lector;
    }

    public static LectorDto toDto(Lector lector) {
        return LectorDto
                .builder()
                .lectorId(lector.getLectorId())
                .firstname(lector.getFirstname())
                .lastname(lector.getLastname())
                .build();
    }
}
