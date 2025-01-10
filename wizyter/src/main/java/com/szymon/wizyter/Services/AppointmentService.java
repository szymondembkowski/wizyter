package com.szymon.wizyter.Services;

import com.szymon.wizyter.Controller.AppointmentController;
import com.szymon.wizyter.Entity.Appointment;
import com.szymon.wizyter.Entity.Doctor;
import com.szymon.wizyter.Entity.Patient;
import com.szymon.wizyter.Repository.AppointmentRepository;
import com.szymon.wizyter.Repository.DoctorRepository;
import com.szymon.wizyter.Repository.PatientRepository;
import com.szymon.wizyter.Requests.AppointmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(AppointmentRequest appointmentRequest) {

        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());

        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> updateAppointment(Long id, Appointment appointmentDetails) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setPatient(appointmentDetails.getPatient());
            appointment.setDoctor(appointmentDetails.getDoctor());
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            return appointmentRepository.save(appointment);
        });
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}