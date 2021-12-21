package com.example.restservice.Structures;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import java.lang.reflect.Type;
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

    @Override
    public float calcArea() {
        ArrayList<Floor> floorList = getFloors();
        float res = 0.0f;
        for (Floor floor : floorList) {
            res = res + floor.calcArea();
        }
        return res;
    }

    @Override
    public float calcLight() {
        float result = 0.f;
        for (Floor floor : floors) { result += floor.calcLight(); }
        return result;
    }

    @Override
    public float calcHeating()
    {
        float area = calcArea();
        if (area == 0)
            return 0;

        return (calcLight()/area);
    }

    @Override
    public float calcCube() {
        ArrayList<Floor> floorList = getFloors();
        float res = 0.0f;
        for (Floor floor : floorList) {
            res = res + floor.calcCube();
        }
        return res;
    }

    @Override
    public float calcEnergy() {
        return (calcHeating()/calcCube());
    }

    public ArrayList<Room> getHighEnergyRooms(float maxEnergy) {
        ArrayList<Room> highEnergyRooms = new ArrayList<>();
        for (Floor floor : floors) {
            ArrayList<Room> roomList = floor.getRooms();
            for (Room room : roomList) {
                if (room.calcEnergy() > maxEnergy) {
                    highEnergyRooms.add(room);
                }
            }
        }
        return highEnergyRooms;
    }

}
