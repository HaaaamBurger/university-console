package com.console.university_console.controller;

import com.console.university_console.model.Lector;
import com.console.university_console.repository.LectorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lector")
@RequiredArgsConstructor
public class LectorController {

    private final LectorRepository lectorRepository;

    @PostMapping()
    public ResponseEntity<Lector> createLector(@RequestBody @Valid Lector lector) {
        return ResponseEntity.ok().body(lectorRepository.save(lector));
    }
}
