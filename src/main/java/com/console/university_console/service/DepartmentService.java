package com.console.university_console.service;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Department;
import com.console.university_console.model.Lector;
import com.console.university_console.repository.DepartmentRepository;
import com.console.university_console.repository.LectorRepository;
import com.console.university_console.util.abstracts.RestAbstraction;
import com.console.university_console.util.exceptions.NotFoundException;
import com.console.university_console.util.mappers.DepartmentMapper;
import com.console.university_console.util.mappers.LectorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements RestAbstraction<DepartmentDto> {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Transactional
    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.fromDto(departmentDto);
        lectorRepository.findById(departmentDto.getHead_of_department_id()).ifPresent(department::setHead_of_department);
        return DepartmentMapper.toDto(departmentRepository.save(department));
    }

    @Transactional
    public LectorDto assignLectorToDepartment(String lectorId, String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("No such department was found"));
        Lector lector = lectorRepository.findById(lectorId).orElseThrow(() -> new NotFoundException("No such lector was found"));
        lector.setHeadingDepartments(List.of(department));
        lectorRepository.save(lector);

        return LectorMapper.toDto(lector);
    };

    @Override
    public DepartmentDto remove(String entityId) {
        return null;
    }

    @Override
    public DepartmentDto update(String entityId, DepartmentDto entity) {
        return null;
    }

    @Override
    public  List<DepartmentDto> getAll() {
        return List.of();
    }

    @Override
    public DepartmentDto getOne(String entityId) {
        return null;
    }
}
