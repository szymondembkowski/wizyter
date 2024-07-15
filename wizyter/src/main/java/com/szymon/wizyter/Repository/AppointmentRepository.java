package com.szymon.wizyter.Repository;

import com.szymon.wizyter.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
