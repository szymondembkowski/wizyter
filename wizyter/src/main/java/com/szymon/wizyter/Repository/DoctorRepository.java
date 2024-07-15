package com.szymon.wizyter.Repository;

import com.szymon.wizyter.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
