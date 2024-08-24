package com.console.university_console.service;

import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Lector;
import com.console.university_console.repository.LectorRepository;
import com.console.university_console.util.abstracts.RestAbstraction;
import com.console.university_console.util.exceptions.EnumNotMatchingException;
import com.console.university_console.util.exceptions.NotFoundException;
import com.console.university_console.util.interfaces.DegreeTypes;
import com.console.university_console.util.mappers.LectorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectorService implements RestAbstraction<LectorDto> {

    private final LectorRepository lectorRepository;

    @Override
    public LectorDto create(LectorDto lectorDto) {
        try {
            EnumUtils.findEnumInsensitiveCase(DegreeTypes.class, lectorDto.getDegree().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new EnumNotMatchingException("You should choose only one of allowed degrees: assistant, associate professor, professor");
        }
        lectorDto.setWorkOnDepartments(List.of());
        Lector lector = LectorMapper.fromDto(lectorDto);
        return LectorMapper.toDto(lectorRepository.save(lector));
    }

    //TODO lector remove
    @Override
    public LectorDto remove(String entityId) {
        return null;
    }

    //TODO lector update
    @Override
    public LectorDto update(String entityId, LectorDto entity) {
        return null;
    }

    @Override
    public List<LectorDto> getAll() {
        List<Lector> lectorList = lectorRepository.findAll();
        return lectorList.stream().map(LectorMapper::toDto).toList();
    }

    @Override
    public LectorDto getOne(String lectorId) {
        Lector lector = lectorRepository.findById(lectorId).orElseThrow(() -> new NotFoundException("No such Lector was found."));
        return LectorMapper.toDto(lector);
    }
}
