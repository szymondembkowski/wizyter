package com.szymon.wizyter.Controller;

import com.szymon.wizyter.Entity.Specialty;
import com.szymon.wizyter.Repository.SpecialtyRepository;
import com.szymon.wizyter.Services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<Specialty> createSpecialty(@RequestBody Specialty specialty) {
        Specialty savedSpecialty = specialtyService.createSpecialty(specialty);
        return ResponseEntity.ok(savedSpecialty);
    }

    @GetMapping
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
        List<Specialty> specialties = specialtyService.getAllSpecialties();
        return ResponseEntity.ok(specialties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable Long id) {
        Specialty specialty = specialtyService.getSpecialtyById(id);
        return ResponseEntity.ok(specialty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable Long id, @RequestBody Specialty specialtyDetails) {
        Specialty updatedSpecialty = specialtyService.updateSpecialty(id, specialtyDetails);
        return ResponseEntity.ok(updatedSpecialty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialty(@PathVariable Long id) {
        specialtyService.deleteSpecialty(id);
        return ResponseEntity.noContent().build();
    }
}