package com.example.restservice.Structures;

import javax.persistence.Entity;
import java.util.ArrayList;

/**
 * Class Floor describes all information about the floor.
 */

@Entity
public class Floor extends Location {

    /**
     * rooms Contains all rooms on the floor.
     */
    private ArrayList<Room> rooms;

    /**
     * Class constructor.
     */
    public Floor(){
        rooms = new ArrayList<Room>();
    }

    /**
     * Class constructor with rooms as argument.
     * @param rooms rooms
     */
    public Floor(ArrayList<Room> rooms) {
        super();
        this.rooms = rooms;
    }

    /**
     * Class constructor with name as argument.
     * @param name name
     * @param rooms rooms
     */
    public Floor(String name, ArrayList<Room> rooms) {
        super(name);
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    /**
     * Method returns values of all class fields as String.
     *
     * @return String with all atributes of class Room
     */

    @Override
    public String toString(String interspace) {
        String msg = super.toString(interspace);
        for (Room room : rooms) {
            msg += "----------------\n";
            msg += room.toString(interspace);
        }
        return msg;
    }

    /**
     * Method calculate area of the floor.
     *
     * @return area
     */

    @Override
    public float calcArea() {
        ArrayList<Room> roomList = getRooms();
        float res = 0.0f;
        for (Room room : roomList) {
            res = res + room.calcArea();
        }
        return res;
    }

    /**
     * Method calculate light in the floor.
     *
     * @return light
     */

    @Override
    public float calcLight() {
        float result = 0.f;
        for (Room room : rooms) { result += room.getLight(); }
        return result;
    }

    /**
     * Method calculate lighting power per unit area in the floor.
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
     * Method calculate volume of the floor.
     *
     * @return volume of the room
     */

    @Override
    public float calcCube() {
        ArrayList<Room> roomList = getRooms();
        float res = 0.0f;
        for (Room room : roomList) {
            res = res + room.calcCube();
        }
        return res;
    }

    /**
     * Method calculate energy consumption for heating per volume unit for the floor.
     *
     * @return energy consumption per volume unit
     */

    @Override
    public float calcEnergy() {
        return (calcLightingPower()/calcCube());
    }

}
