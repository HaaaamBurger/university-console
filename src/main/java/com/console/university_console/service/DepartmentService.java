package com.console.university_console.service;

import com.console.university_console.dto.DepartmentDto;
import com.console.university_console.model.Department;
import com.console.university_console.repository.DepartmentRepository;
import com.console.university_console.util.abstracts.RestAbstraction;
import com.console.university_console.util.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements RestAbstraction<DepartmentDto> {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto create(DepartmentDto entity) {
        Department department = DepartmentMapper.fromDto(entity);

        return DepartmentMapper.toDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto remove(String entityId) {
        return null;
    }

    @Override
    public DepartmentDto update(String entityId, DepartmentDto entity) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return List.of();
    }

    @Override
    public DepartmentDto getOne(String entityId) {
        return null;
    }
}
