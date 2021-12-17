package com.example.restservice;

import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

class LoadDatabase {

    public static void initDatabase(BuildingRepository repository) {
        ArrayList<Room> rooms1 = new ArrayList<Room>();
        rooms1.add(new Room());

        ArrayList<Floor> floors1 = new ArrayList<Floor>();
        floors1.add(new Floor(rooms1));

        repository.save(new Building(floors1));
    }
}