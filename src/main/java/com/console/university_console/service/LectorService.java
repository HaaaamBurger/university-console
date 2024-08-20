package com.console.university_console.service;

import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Lector;
import com.console.university_console.repository.LectorRepository;
import com.console.university_console.util.abstracts.RestAbstraction;
import com.console.university_console.util.mappers.LectorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectorService implements RestAbstraction<LectorDto> {

    private final LectorRepository lectorRepository;

    @Override
    public LectorDto create(LectorDto lectorDto) {
        Lector lector = LectorMapper.fromDto(lectorDto);
        return LectorMapper.toDto(lectorRepository.save(lector));
    }

    @Override
    public LectorDto remove(String entityId) {
        return null;
    }

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
    public LectorDto getOne(String entityId) {
        return null;
    }
}
