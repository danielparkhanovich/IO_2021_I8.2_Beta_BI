package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Building extends Location {

    private final Floor[] floors;

    public Building(){
        floors = new Floor[0];
    }

    public Building(Floor[] floors) {
        super();
        this.floors = floors;
    }

    public Building(String name, Floor[] floors) {
        super(name);
        this.floors = floors;
    }

    public Floor[] getFloors(){
        return floors;
    }

    @Override
    public String toString() {
        String msg = super.toString("");
        for (Floor floor : floors) {
            msg += "----------------\n";
            msg += floor.toString("---> ");
        }
        return msg;
    }
}
