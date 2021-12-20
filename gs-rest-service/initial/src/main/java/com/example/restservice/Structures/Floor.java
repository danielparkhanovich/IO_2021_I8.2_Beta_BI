package com.example.restservice.Structures;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Floor extends Location {

    private ArrayList<Room> rooms;

    public Floor(){
        rooms = new ArrayList<Room>();
    }

    public Floor(ArrayList<Room> rooms) {
        super();
        this.rooms = rooms;
    }

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

    @Override
    public String toString(String interspace) {
        String msg = super.toString(interspace);
        for (Room room : rooms) {
            msg += "----------------\n";
            msg += room.toString(interspace);
        }
        return msg;
    }

    public float calcHeating() {
        float result = 0.f;
        int i = rooms.size();
        for (Room room : rooms) { result += room.calcHeating(); }
        return (result/i);
    }
}
