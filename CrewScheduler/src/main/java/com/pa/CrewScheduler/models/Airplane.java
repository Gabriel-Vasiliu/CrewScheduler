package com.pa.CrewScheduler.models;

import javax.persistence.*;

@Entity
@Table(name = "airplanes", schema = "airport")
public class Airplane implements Comparable<Airplane> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "capacity", nullable = false)
    private int capacity;
    @Basic
    @Column(name = "flight_attendants", nullable = false)
    private int flightAttendants;

    public int getFlightAttendants() {
        return flightAttendants;
    }

    public void setFlightAttendants(int flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + ", capacity= " + capacity;
    }

    @Override
    public int compareTo(Airplane airplane) {
        return Integer.compare(getCapacity(), airplane.getCapacity());
    }
}
