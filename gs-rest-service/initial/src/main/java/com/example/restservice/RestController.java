package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.Exceptions.LocationNotFoundException;
import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Location;
import com.example.restservice.Structures.Room;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static RestController instance;
    public BuildingRepository repository;

    public RestController() {
        repository = new BuildingRepository();
        LoadDatabase.initDatabase(repository);
    }

    public static RestController getInstance() {
        if (instance == null) {
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
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        found.getFloors().add(newFloor);
        return newFloor;
    }


    @PostMapping("/buildings/build{id}/floor{id2}")
    public Room addRoom(@PathVariable Long id, @PathVariable Long id2, @RequestBody Room newRoom) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        Floor floor = ((Floor) found);
        floor.getRooms().add(newRoom);
        return newRoom;
    }

    @PutMapping("/buildings/build{id}")
    public Building updateBuilding(@PathVariable Long id, @RequestBody Building newBuilding) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        repository.update(id, newBuilding);
        return repository.findById(id);
    }

    @PutMapping("/buildings/build{id}/floor{id2}")
    public Floor updateFloor(@PathVariable Long id, @PathVariable Long id2, @RequestBody Floor newFloor) throws LocationNotFoundException {
        Building buildingFound = repository.findById(id);
        if (buildingFound == null) {
            throw new LocationNotFoundException(id);
        }
        repository.update(id2, buildingFound, newFloor);
        return (Floor) repository.findLocationById(id2);
    }

    @PutMapping("/buildings/build{id}/floor{id2}/room{id3}")
    public Room updateRoom(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3, @RequestBody Room newRoom) throws LocationNotFoundException {
        Building buildingFound = repository.findById(id);
        Location found = repository.findLocationById(id2);
        if (buildingFound == null) {
            throw new LocationNotFoundException(id);
        } else if (found == null) {
            throw new LocationNotFoundException(id2);
        } else if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        repository.update(id3, buildingFound, (Floor) found, newRoom);
        return (Room) repository.findLocationById(id3);
    }

    @GetMapping("/buildings/build{id}")
    public Building getBuilding(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}")
    public Floor getFloor(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        return (Floor) found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}")
    public Room getRoom(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return (Room) found;
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}area")
    public float getRoomArea(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return found.calcArea();
    }

    @GetMapping("/buildings/build{id}/floor{id2}area")
    public float getFloorArea(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        return found.calcArea();
    }

    @GetMapping("/buildings/build{id}area")
    public float getBuildingArea(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcArea();
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}lightingPower")
    public float getRoomLightingPower(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return found.calcLightingPower();
    }

    @GetMapping("/buildings/build{id}/floor{id2}lightingPower")
    public float getFloorLightingPower(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        return found.calcLightingPower();
    }

    @GetMapping("/buildings/build{id}lightingPower")
    public float getBuildingLightingPower(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcLightingPower();
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}cube")
    public float getRoomCube(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return found.calcCube();
    }

    @GetMapping("/buildings/build{id}/floor{id2}cube")
    public float getFloorCube(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        return found.calcCube();
    }

    @GetMapping("/buildings/build{id}cube")
    public float getBuildingCube(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcCube();
    }

    @GetMapping("/buildings/build{id}/floor{id2}/room{id3}energy")
    public float getRoomEnergy(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3) throws LocationNotFoundException {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return found.calcEnergy();
    }

    @GetMapping("/buildings/build{id}/floor{id2}energy")
    public float getFloorEnergy(@PathVariable Long id, @PathVariable Long id2) throws LocationNotFoundException {
        Location found = repository.findLocationById(id2);
        if (!(found instanceof Floor)) {
            throw new LocationNotFoundException(id2);
        }
        return found.calcEnergy();
    }

    @GetMapping("/buildings/build{id}energy")
    public float getBuildingEnergy(@PathVariable Long id) {
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcEnergy();
    }

    @GetMapping("/buildings/building{id}/highEnergyRooms:{energy}")
    public ArrayList<Room> getHighEnergyRooms(@PathVariable Long id, @PathVariable float energy){
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcHighEnergyRooms(energy);
    }

    @GetMapping("/buildings/building{id}/lowEnergyRooms:{energy}")
    public ArrayList<Room> getLowEnergyRooms(@PathVariable Long id, @PathVariable float energy){
        Building found = repository.findById(id);
        if (found == null) {
            throw new LocationNotFoundException(id);
        }
        return found.calcLowEnergyRooms(energy);
    }

    @GetMapping("/buildings/building{id}/floor{id2}/room{id3}/calcTax:{costPerM2}:{taxRate}")
    public float calcTax(@PathVariable Long id, @PathVariable Long id2, @PathVariable Long id3, @PathVariable int costPerM2, @PathVariable float taxRate) throws LocationNotFoundException  {
        Location found = repository.findLocationById(id3);
        if (!(found instanceof Room)) {
            throw new LocationNotFoundException(id3);
        }
        return ((Room)found).calcTax(costPerM2, taxRate);
    }
}
