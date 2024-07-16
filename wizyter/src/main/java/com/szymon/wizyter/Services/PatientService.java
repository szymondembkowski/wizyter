package com.szymon.wizyter.Services;

import com.szymon.wizyter.Entity.Patient;
import com.szymon.wizyter.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Transactional
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setPesel(patientDetails.getPesel());
            patient.setPhoneNumber(patientDetails.getPhoneNumber());
            patient.setEmail(patientDetails.getEmail());
            return patientRepository.save(patient);
        });
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}