package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Floor extends Location {

    private final Room[] rooms;

    public Floor(){
        rooms = new Room[0];
    }

    public Floor(Room[] rooms) {
        super();
        this.rooms = rooms;
    }

    public Floor(String name, Room[] rooms) {
        super(name);
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
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
}
