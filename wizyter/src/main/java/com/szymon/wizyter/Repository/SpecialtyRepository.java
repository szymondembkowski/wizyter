package com.szymon.wizyter.Repository;

import com.szymon.wizyter.Entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
