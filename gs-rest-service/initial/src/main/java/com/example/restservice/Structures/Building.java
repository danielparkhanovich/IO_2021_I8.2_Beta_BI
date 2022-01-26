package com.example.restservice.Structures;

import javax.persistence.Entity;
import java.util.ArrayList;

/**
 * Class Building describes all information about the building.
 */

@Entity
public class Building extends Location {

    /**
     * floors Contains all floors in the building.
     */
    private ArrayList<Floor> floors;

    /**
     * Class constructor.
     */
    public Building(){
        floors = new ArrayList<Floor>();
    }

    /**
     * Class constructor with floors as argument.
     * @param floors floors
     */
    public Building(ArrayList<Floor> floors) {
        super();
        this.floors = floors;
    }

    /**
     * Class constructor with name and floors as argument.
     * @param name name
     * @param floors floors
     */
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


    /**
     * Method returns values of all class fields as String.
     *
     * @return String with all atributes of class Room
     */
    @Override
    public String toString() {
        String msg = super.toString("");
        for (Floor floor : floors) {
            msg += "----------------\n";
            msg += floor.toString("---> ");
        }
        return msg;
    }

    /**
     * Method calculate area of the building.
     *
     * @return area
     */
    @Override
    public float calcArea() {
        ArrayList<Floor> floorList = getFloors();
        float res = 0.0f;
        for (Floor floor : floorList) {
            res = res + floor.calcArea();
        }
        return res;
    }

    /**
     * Method calculate light in the building.
     *
     * @return light
     */
    @Override
    public float calcLight() {
        float result = 0.f;
        for (Floor floor : floors) { result += floor.calcLight(); }
        return result;
    }

    /**
     * Method calculate lighting power per unit area in the building.
     *
     * @return lighting power per unit area
     */
    @Override
    public float calcLightingPower()
    {
        float area = calcArea();
        if (area == 0)
            return 0;

        return (calcLight()/area);
    }

    /**
     * Method calculate volume of the building.
     *
     * @return volume of the room
     */
    @Override
    public float calcCube() {
        ArrayList<Floor> floorList = getFloors();
        float res = 0.0f;
        for (Floor floor : floorList) {
            res = res + floor.calcCube();
        }
        return res;
    }
    /**
     * Method calculate energy consumption for heating per volume unit for the building.
     *
     * @return energy consumption per volume unit
     */
    @Override
    public float calcEnergy() {
        return (calcLightingPower()/calcCube());
    }

    /**
     * Method for get rooms with higher energy than maxEnergy.
     *
     * @param maxEnergy maxEnergy
     * @return rooms with higher energy
     */
    public ArrayList<Room> calcHighEnergyRooms(float maxEnergy) {
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

    /**
     * Method for get rooms with lower energy than minEnergy.
     *
     * @param minEnergy minEnergy
     * @return rooms with lower energy
     */
    public ArrayList<Room> calcLowEnergyRooms(float minEnergy) {
        ArrayList<Room> lowEnergyRooms = new ArrayList<>();
        for (Floor floor : floors) {
            ArrayList<Room> roomList = floor.getRooms();
            for (Room room : roomList) {
                if (room.calcEnergy() <= minEnergy) {
                    lowEnergyRooms.add(room);
                }
            }
        }
        return lowEnergyRooms;
    }

}
