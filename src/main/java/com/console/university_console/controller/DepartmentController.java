package com.console.university_console.controller;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> create(@RequestBody @Valid DepartmentDto departmentDto) {
        DepartmentDto createdDepartment = departmentService.create(departmentDto);
        return ResponseEntity
                .ok()
                .body(createdDepartment);
    }

}
