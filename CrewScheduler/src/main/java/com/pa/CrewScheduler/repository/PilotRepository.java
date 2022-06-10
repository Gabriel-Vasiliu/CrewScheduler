package com.pa.CrewScheduler.repository;

import com.pa.CrewScheduler.models.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {
}
