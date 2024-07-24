package com.szymon.wizyter.Controller;

import com.szymon.wizyter.Entity.Specialty;
import com.szymon.wizyter.Repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    private static final Logger logger = LoggerFactory.getLogger(SpecialtyController.class);

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @PostMapping
    public ResponseEntity<Specialty> createSpecialty(@RequestBody Specialty specialty) {
        logger.info("Received request to create specialty: {}", specialty);
        Specialty savedSpecialty = specialtyRepository.save(specialty);
        return ResponseEntity.ok(savedSpecialty);
    }

    @GetMapping
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
        List<Specialty> specialties = specialtyRepository.findAll();
        return ResponseEntity.ok(specialties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable Long id) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialty not found"));
        return ResponseEntity.ok(specialty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable Long id, @RequestBody Specialty specialtyDetails) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialty not found"));

        specialty.setName(specialtyDetails.getName());

        Specialty updatedSpecialty = specialtyRepository.save(specialty);
        return ResponseEntity.ok(updatedSpecialty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialty(@PathVariable Long id) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialty not found"));

        specialtyRepository.delete(specialty);
        return ResponseEntity.noContent().build();
    }
}
