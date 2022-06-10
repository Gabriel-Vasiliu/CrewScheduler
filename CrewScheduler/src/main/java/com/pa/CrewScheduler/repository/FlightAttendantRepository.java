package com.pa.CrewScheduler.repository;

import com.pa.CrewScheduler.models.FlightAttendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightAttendantRepository extends JpaRepository<FlightAttendant, Integer> {
}
