package com.example.restservice;

import java.util.List;

import com.example.restservice.Exceptions.LocationNotFoundException;
import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Location;
import com.example.restservice.Structures.Room;
import org.springframework.boot.web.embedded.undertow.UndertowWebServer;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static RestController instance;
    public BuildingRepository repository;

    public RestController(){
        repository = new BuildingRepository();
        LoadDatabase.initDatabase(repository);
    }

    public static RestController getInstance(){
        if (instance == null){
            instance = new RestController();
        }
        return instance;
    }

    @GetMapping("/buildings")
    public List<Building> getRepository() {
        return repository.findAll();
    }

    @PostMapping("/buildings")
    public Building addBuilding(@RequestBody Building newBuilding) {
        return repository.save(newBuilding);
    }

    // Single item

    @PostMapping("/buildings/build{id}")
    public Floor addFloor(@PathVariable Long id, @RequestBody Floor newFloor) {
        Building found = repository.findById(id);
        if (found == null){
            throw new LocationNotFoundException(id);
        }
        found.getFloors().add(newFloor);
        return newFloor;
    }


    @PostMapping("/buildings/build{id}/floor{id2}")
    public Room addRoom(@PathVariable Long id, @PathVariable Long id2, @RequestBody Room newRoom) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)){
            throw new LocationNotFoundException(id2);
        }
        Floor floor = ((Floor) found);
        floor.getRooms().add(newRoom);
        return newRoom;
    }

    @PutMapping("/buildings/build{id}")
    public Building updateBuilding(@PathVariable Long id, @RequestBody Building newBuilding) {
        Building found = repository.findById(id);
        if (found == null){
            throw new LocationNotFoundException(id);
        }
        found = newBuilding;
        return found;
    }

    @PutMapping("/buildings/build{id}/floor{id2}")
    public Floor updateFloor(@PathVariable Long id, @PathVariable Long id2, @RequestBody Floor newFloor) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)){
            throw new LocationNotFoundException(id2);
        }
        found = newFloor;
        return (Floor) found;
    }

    @PutMapping("/buildings/build{id}/floor{id2}/room{id3}")
    public Room updateRoom(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3, @RequestBody Room newRoom) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)){
            throw new LocationNotFoundException(id2);
        }
        found = newRoom;
        return (Room)found;
    }

    @GetMapping("/buildings/build{id}")
    public Building getBuilding(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null){
            throw new LocationNotFoundException(id);
        }
        return found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}")
    public Floor getFloor(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)){
            throw new LocationNotFoundException(id2);
        }
        return (Floor) found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}")
    public Room getRoom(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)){
            throw new LocationNotFoundException(id);
        }
        return (Room) found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}cube")
    public float getRoomCube(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)){
            throw new LocationNotFoundException(id);
        }
        return found.calcCube();
    }

    @GetMapping("/buildings/build{id}/floor{id2}cube")
    public float getFloorCube(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)){
            throw new LocationNotFoundException(id2);
        }
        return found.calcCube();
    }

    @GetMapping("/buildings/build{id}cube")
    public float getBuildingCube(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null){
            throw new LocationNotFoundException(id);
        }
        return found.calcCube();
    }
}