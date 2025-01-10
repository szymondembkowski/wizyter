package com.szymon.wizyter.Services;

import com.szymon.wizyter.Entity.Specialty;
import com.szymon.wizyter.Repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.findById(id).orElseThrow(() -> new RuntimeException("Specialty not found"));
    }

    public Specialty updateSpecialty(Long id, Specialty specialtyDetails) {
        Specialty specialty = getSpecialtyById(id);
        specialty.setName(specialtyDetails.getName());
        return specialtyRepository.save(specialty);
    }

    public void deleteSpecialty(Long id) {
        Specialty specialty = getSpecialtyById(id);
        specialtyRepository.delete(specialty);
    }
}