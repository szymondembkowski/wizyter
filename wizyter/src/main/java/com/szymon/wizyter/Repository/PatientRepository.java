package com.szymon.wizyter.Repository;

import com.szymon.wizyter.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}