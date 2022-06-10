package com.pa.CrewScheduler.service;

import com.pa.CrewScheduler.models.Airplane;
import com.pa.CrewScheduler.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirplaneService {
    @Autowired
    private AirplaneRepository repository;

    /**
     * Returns all planes from the database.
     *
     * @return all planes from the database or new ArrayList otherwise.
     */
    public List<Airplane> getAllAirplanes() {
        List<Airplane> airplanes = repository.findAll();
        if (!airplanes.isEmpty()) {
            return airplanes;
        }
        return new ArrayList<>();
    }
}
