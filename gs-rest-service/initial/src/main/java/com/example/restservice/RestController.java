package com.example.restservice;

import java.util.List;

import com.example.restservice.Exceptions.BuildingNotFoundException;
import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static RestController instance;
    public BuildingRepository repository;


    public RestController(){
        repository = new BuildingRepository();
    }

    public static RestController getInstance(){
        if (instance == null){
            instance = new RestController();
        }
        return instance;
    }

    @GetMapping("/buildings")
    public List<Building> getRepository() {
        repository.save(new Building(0L, new Floor[]{new Floor(0L, new Room[]{new Room(0L)})}));
        return repository.findAll();
    }

    @PostMapping("/buildings")
    Building addBuilding(@RequestBody Building newBuilding) {
        return repository.save(newBuilding);
    }

    // Single item

    @GetMapping("/buildings/{id}")
    public Building getBuilding(@PathVariable Long id) throws BuildingNotFoundException {
        Building found = repository.findById(id);
        if (found == null){
            throw new BuildingNotFoundException(id);
        }
        return found;
    }
}