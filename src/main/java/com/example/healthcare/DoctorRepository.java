package com.example.healthcare;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {
    private final Map<String, List<LocalDate>> schedule = new HashMap<>();

    public DoctorRepository() {
        schedule.put("DOC101", new ArrayList<>(Arrays.asList(
            LocalDate.parse("2025-04-10"),
            LocalDate.parse("2025-04-11"),
            LocalDate.parse("2025-04-15")
        )));
        schedule.put("DOC102", new ArrayList<>(Arrays.asList(
            LocalDate.parse("2025-04-12"),
            LocalDate.parse("2025-04-13")
        )));
    }

    public synchronized boolean isAvailable(String doctorId, LocalDate date) {
        List<LocalDate> dates = schedule.get(doctorId);
        return dates != null && dates.contains(date);
    }

    public synchronized boolean book(String doctorId, LocalDate date) {
        List<LocalDate> dates = schedule.get(doctorId);
        if (dates != null && dates.contains(date)) {
            dates.remove(date);
            return true;
        }
        return false;
    }
}
