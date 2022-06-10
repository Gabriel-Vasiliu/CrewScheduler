package com.pa.CrewScheduler.service;

import com.pa.CrewScheduler.models.Pilot;
import com.pa.CrewScheduler.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PilotService {
    @Autowired
    private PilotRepository repository;

    /**
     * Returns all pilots from the database.
     *
     * @return all pilots from the database or new ArrayList otherwise.
     */
    public List<Pilot> getAllPilots() {
        List<Pilot> pilots = repository.findAll();
        if (!pilots.isEmpty()) {
            return pilots;
        }
        return new ArrayList<>();
    }
}
