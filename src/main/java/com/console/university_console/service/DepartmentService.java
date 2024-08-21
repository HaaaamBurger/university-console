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
import java.util.Optional;

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

        List<Department> headingDepartments = lector.getHeadingDepartments();
        headingDepartments.add(department);

        department.setHead_of_department(lector);

        lector.setHeadingDepartments(headingDepartments);

        lectorRepository.save(lector);
        departmentRepository.save(department);

        return LectorMapper.toDto(lector);
    };

    //TODO department remove
    @Override
    public DepartmentDto remove(String entityId) {
        return null;
    }

    //TODO department update
    @Override
    public DepartmentDto update(String entityId, DepartmentDto entity) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(DepartmentMapper::toDto).toList();
    }

    @Override
    public DepartmentDto getOne(String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("No such Department was found."));
        return DepartmentMapper.toDto(department);
    }

    @Transactional
    public String getHeadOfDepartment(String departmentId) {
        DepartmentDto departmentDto = getOne(departmentId);
        System.out.println(departmentDto.getDepartmentId());
//        Lector lector = lectorRepository.findById(departmentDto.getHead_of_department_id()).orElseThrow(() -> new NotFoundException("No lector was found."));
//        return "Head of %s department is %s".formatted(departmentDto.getName(), lector.getFirstname() + " " + lector.getLastname());
        return "hello";

    }


}
