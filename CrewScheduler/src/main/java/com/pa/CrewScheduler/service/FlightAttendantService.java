package com.pa.CrewScheduler.service;

import com.pa.CrewScheduler.models.FlightAttendant;
import com.pa.CrewScheduler.repository.FlightAttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightAttendantService {
    @Autowired
    private FlightAttendantRepository repository;

    /**
     * Returns all flight attendants from the database.
     *
     * @return all flight attendants from the database or new ArrayList otherwise.
     */
    public List<FlightAttendant> getAllFlightAttendants() {
        List<FlightAttendant> flightAttendants = repository.findAll();
        if (!flightAttendants.isEmpty()) {
            return flightAttendants;
        }
        return new ArrayList<>();
    }
}
