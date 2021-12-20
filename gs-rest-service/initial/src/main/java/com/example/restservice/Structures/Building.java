package com.example.restservice.Structures;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Building extends Location {

    private ArrayList<Floor> floors;

    public Building(){
        floors = new ArrayList<Floor>();
    }

    public Building(ArrayList<Floor> floors) {
        super();
        this.floors = floors;
    }

    public Building(String name, ArrayList<Floor> floors) {
        super(name);
        this.floors = floors;
    }

    public ArrayList<Floor> getFloors(){
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors){
        this.floors = floors;
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

    public float calcHeating() {
        float result = 0.f;
        int i = floors.size();
        for (Floor floor : floors) { result += floor.calcHeating(); }
        return (result/i);
    }
}
