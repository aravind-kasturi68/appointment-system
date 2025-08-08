package com.example.healthcare;

import java.time.LocalDate;

public class AppointmentService {
    private DoctorRepository doctorRepository;

    // Setter for Spring XML
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String book(String doctorId, String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            boolean success = doctorRepository.book(doctorId, date);
            return success ? "Appointment confirmed" : "Doctor not available";
        } catch (Exception e) {
            return "Invalid date format. Use yyyy-MM-dd";
        }
    }
}
