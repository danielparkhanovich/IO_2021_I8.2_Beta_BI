package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Building extends Location {

    private Floor[] floors;

    public Building(Long id, Floor[] floors) {
        super(id);
        this.floors = floors;
    }

    public Building(Long id, String name, Floor[] floors) {
        super(id, name);
        this.floors = floors;
    }
}
