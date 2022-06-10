package com.pa.CrewScheduler.models;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private Airplane airplane;
    private Pilot pilot;
    private List<FlightAttendant> flightAttendants = new ArrayList<>();

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public List<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }

    public void addFlightAttendant(FlightAttendant flightAttendant) {
        this.flightAttendants.add(flightAttendant);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(airplane).append("; pilot: ").append(pilot).append("; flight attendants: ");
        for (FlightAttendant flightAttendant : flightAttendants) {
            stringBuilder.append(flightAttendant).append(" | ");
        }
        return stringBuilder.toString();
    }
}
