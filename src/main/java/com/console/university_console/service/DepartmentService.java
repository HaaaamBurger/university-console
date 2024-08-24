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
        Lector lector = lectorRepository.findById(departmentDto.getHeadOfDepartmentId()).orElseThrow(() -> new NotFoundException("No lector was found"));

        System.out.println(departmentDto.getHeadOfDepartmentId());

        Department department = DepartmentMapper.fromDto(departmentDto);
        department.setHeadOfDepartment(lector);
        department.setDepartmentEmployees(List.of());

        return DepartmentMapper.toDto(departmentRepository.save(department));
    }

    @Transactional
    public LectorDto assignLectorToDepartment(String lectorId, String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("No department was found"));
        Lector lector = lectorRepository.findById(lectorId).orElseThrow(() -> new NotFoundException("No lector was found"));

//        lector.getHeadingDepartments().add(department);

        lectorRepository.save(lector);

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
        Lector lector = lectorRepository.findById(departmentDto.getHeadOfDepartment().getLectorId()).orElseThrow(() -> new NotFoundException("No lector was found."));
        return "Head of %s department is %s.".formatted(departmentDto.getName(), lector.getFirstname() + " " + lector.getLastname());
    }

//    @Transactional
//    public StatisticsDto getDepartmentStatistics(String departmentId) {
//        List<Lector> lectorsByDepartmentId = departmentRepository.findLectorsByDepartmentId(departmentId);
//
//        long assistantsCount = lectorsByDepartmentId.stream()
//                .filter(lector -> "assistant".equals(lector.getDegree()))
//                .count();
//
//        long associateProfessorsCount = lectorsByDepartmentId.stream()
//                .filter(lector -> "associate_professor".equals(lector.getDegree()))
//                .count();
//
//        long professorsCount = lectorsByDepartmentId.stream()
//                .filter(lector -> "professor".equals(lector.getDegree()))
//                .count();
//
//        return StatisticsDto
//                .builder()
//                .assistans((int) assistantsCount)
//                .associate_professors((int) associateProfessorsCount)
//                .professors((int) professorsCount)
//                .build();
//
//    }


}
