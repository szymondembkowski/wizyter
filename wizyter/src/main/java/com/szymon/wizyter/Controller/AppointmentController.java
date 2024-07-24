package com.szymon.wizyter.Controller;

import com.szymon.wizyter.Entity.Appointment;
import com.szymon.wizyter.Entity.Doctor;
import com.szymon.wizyter.Entity.Patient;
import com.szymon.wizyter.Repository.AppointmentRepository;
import com.szymon.wizyter.Repository.DoctorRepository;
import com.szymon.wizyter.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    public static class AppointmentRequest {
        private Long patientId;
        private Long doctorId;
        private LocalDateTime appointmentDate;

        public Long getPatientId() {
            return patientId;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public Long getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(Long doctorId) {
            this.doctorId = doctorId;
        }

        public LocalDateTime getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(LocalDateTime appointmentDate) {
            this.appointmentDate = appointmentDate;
        }
    }
}
