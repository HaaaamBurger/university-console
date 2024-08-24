package com.console.university_console.controller;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.dto.LectorDto;
import com.console.university_console.dto.StatisticsDto;
import com.console.university_console.model.Lector;
import com.console.university_console.service.DepartmentService;
import com.console.university_console.util.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/assign/lector")
    public ResponseEntity<LectorDto> assignLectorToDepartment(@RequestParam String lectorId, @RequestParam String departmentId) {
        return ResponseEntity
                .ok()
                .body(departmentService.assignLectorToDepartment(lectorId, departmentId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return ResponseEntity
                .ok()
                .body(departmentService.getAll());
    }

    @GetMapping("/head_of_department/{departmentId}")
    public ResponseEntity<String> getHeadOfDepartment(@PathVariable String departmentId) {
        return ResponseEntity
                .ok()
                .body(departmentService.getHeadOfDepartment(departmentId));
    }

//    @GetMapping("/statistics/{departmentId}")
//    public ResponseEntity<StatisticsDto> getDepartmentStatistics(@PathVariable String departmentId) {
//        return ResponseEntity
//                .ok()
//                .body(departmentService.getDepartmentStatistics(departmentId));
//    }
}
