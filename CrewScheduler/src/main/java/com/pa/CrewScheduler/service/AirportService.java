package com.pa.CrewScheduler.service;

import com.pa.CrewScheduler.models.Airplane;
import com.pa.CrewScheduler.models.Flight;
import com.pa.CrewScheduler.models.FlightAttendant;
import com.pa.CrewScheduler.models.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AirportService {
    @Autowired
    private PilotService pilotService;
    @Autowired
    private AirplaneService airplaneService;
    @Autowired
    private FlightAttendantService flightAttendantService;

    private List<Pilot> pilots;
    private List<Airplane> airplanes;
    private List<FlightAttendant> flightAttendants;
    private List<Flight> flights;
    private List<Airplane> airplanesWithoutStaff;
    private int indexFlightAttendants;

    /**
     * Read data from the database.
     */
    public void readData() {
        flights = new ArrayList<>();
        airplanesWithoutStaff = new ArrayList<>();
        pilots = pilotService.getAllPilots();

        airplanes = airplaneService.getAllAirplanes();
        flightAttendants = flightAttendantService.getAllFlightAttendants();
        if (!pilots.isEmpty() && !airplanes.isEmpty()) {
            staffAllocation();
        }
    }

    /**
     * Sort airplanes and pilots.
     * Depending on the capacity and type of pilots, they are assigned to airplanes.
     * Airplanes without pilot or flight attendants will be saved in airplanesWithoutStaff.
     */
    private void staffAllocation() {
        Collections.sort(airplanes);
        Collections.sort(pilots);
        pilots.remove(pilots.size() - 1);
        pilots.remove(pilots.size() - 1);
        indexFlightAttendants = 0;
        int isAdded;

        int indexPilot = pilots.size() - 1;
        int indexAirplane = airplanes.size() - 1;
        while (indexPilot >= 0 && indexAirplane >= 0) {
            Pilot pilot = pilots.get(indexPilot);
            Airplane airplane = airplanes.get(indexAirplane);
            if (Objects.equals(pilot.getType(), "major")) {
                isAdded = addFlight(airplane, pilot);
            } else if (Objects.equals(pilot.getType(), "regional") && airplane.getCapacity() < 200) {
                isAdded = addFlight(airplane, pilot);
            } else if (Objects.equals(pilot.getType(), "corporate") && airplane.getCapacity() < 50) {
                isAdded = addFlight(airplane, pilot);
            } else {
                airplanesWithoutStaff.add(airplane);
                isAdded = 0;
            }
            if (isAdded != 0) {
                indexPilot--;
            }
            indexAirplane--;
        }
        if (indexPilot == -1 && indexAirplane >= 0) {
            while (indexAirplane >= 0) {
                airplanesWithoutStaff.add(airplanes.get(indexAirplane));
                indexAirplane--;
            }
        }
    }

    /**
     * For each pair of pilot aircraft, distribute the minimum number of flight attendants.
     * If there are not enough flight attendants the plane will be added to airplanesWithoutStaff.
     *
     * @param airplane
     * @param pilot
     * @return -1 if size of flightAttendants = indexFlightAttendants.
     * 1 if there are flight attendants for the aircraft.
     * 0 if there are no flight attendants for the aircraft
     */
    private int addFlight(Airplane airplane, Pilot pilot) {
        if (flightAttendants.size() == indexFlightAttendants) {
            airplanesWithoutStaff.add(airplane);
            return -1;
        }
        Flight flight = new Flight();
        flight.setAirplane(airplane);
        flight.setPilot(pilot);

        int nrFlightAttendants = airplane.getFlightAttendants();
        if (nrFlightAttendants <= flightAttendants.size()) {
            for (int index = 0; index < nrFlightAttendants; index++) {
                flight.addFlightAttendant(flightAttendants.get(indexFlightAttendants + index));
            }
            indexFlightAttendants++;
            flights.add(flight);
            return 1;
        } else {
            airplanesWithoutStaff.add(airplane);
            return 0;
        }
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public List<Airplane> getAirplanesWithoutStaff() {
        return airplanesWithoutStaff;
    }
}
