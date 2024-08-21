package com.console.university_console.controller;

import com.console.university_console.dto.LectorDto;
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
    public ResponseEntity<LectorDto> create(@RequestBody @Valid LectorDto lectorDto) {
        return ResponseEntity.ok().body(lectorService.create(lectorDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LectorDto>> getAll() {
        return ResponseEntity.ok().body(lectorService.getAll());
    }
    @GetMapping("/{lectorId}")
    public ResponseEntity<LectorDto> getOne(@PathVariable String lectorId) {
        return ResponseEntity.ok().body(lectorService.getOne(lectorId));
    }
}
