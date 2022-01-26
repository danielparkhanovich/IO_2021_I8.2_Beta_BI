package com.example.restservice;

import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Class LoadDatabase serves for the data save/load
 */
class LoadDatabase {

    /**
     * Class LoadDatabase serves for the data save/load.
     *
     * @param repository repository - for insert into data.
     */
    public static void initDatabase(BuildingRepository repository) {
        ArrayList<Room> rooms1 = new ArrayList<Room>();
        rooms1.add(new Room());

        ArrayList<Floor> floors1 = new ArrayList<Floor>();
        floors1.add(new Floor(rooms1));

        repository.save(new Building(floors1));
    }
}