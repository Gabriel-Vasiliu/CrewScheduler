package com.pa.CrewScheduler.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pilots", schema = "airport")
public class Pilot implements Comparable<Pilot> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic
    @Column(name = "type", nullable = false, length = 40)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age= " + age + ", type= " + type;
    }

    @Override
    public int compareTo(Pilot pilot) {
        String type1 = getType();
        String type2 = pilot.getType();

        if (Objects.equals(type1, "major")) {
            if (Objects.equals(type2, "major")) {
                return 0;
            } else {
                return 1;
            }
        } else if (Objects.equals(type1, "regional")) {
            if (Objects.equals(type2, "major")) {
                return -1;
            } else if (Objects.equals(type2, "regional")) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (Objects.equals(type2, "corporate")) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
