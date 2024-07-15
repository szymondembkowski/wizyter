package com.szymon.wizyter.Controller;

import com.szymon.wizyter.Entity.Patient;
import com.szymon.wizyter.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Pobieranie wszystkich pacjentów
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Dodawanie nowego pacjenta
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }


    // Usunięcie pacjenta
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
