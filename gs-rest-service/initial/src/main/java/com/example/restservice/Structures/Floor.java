package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Floor extends Location {

    private Room[] rooms;

    public Floor(Long id, Room[] rooms) {
        super(id);
        this.rooms = rooms;
    }

    public Floor(Long id, String name, Room[] rooms) {
        super(id, name);
        this.rooms = rooms;
    }
}
