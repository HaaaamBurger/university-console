package com.console.university_console.controller;

import com.console.university_console.dto.LectorDto;
import com.console.university_console.model.Lector;
import com.console.university_console.repository.LectorRepository;
import com.console.university_console.service.LectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lector")
@RequiredArgsConstructor
public class LectorController {

    private final LectorService lectorService;

    @PostMapping()
    public ResponseEntity<LectorDto> createLector(@RequestBody @Valid LectorDto lectorDto) {
        return ResponseEntity.ok().body(lectorService.create(lectorDto));
    }

    @GetMapping
    public ResponseEntity<List<LectorDto>> getAll() {
        return ResponseEntity.ok().body(lectorService.getAll());
    }
}
