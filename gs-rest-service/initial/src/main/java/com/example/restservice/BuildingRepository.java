package com.example.restservice;

import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Location;
import com.example.restservice.Structures.Room;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

class BuildingRepository {

    HashMap<Long, Building> buildingsDict;

    public BuildingRepository(){
        buildingsDict = new HashMap<Long, Building>();
    }

    public List<Building> findAll() {
        ArrayList<Building> buildingsList = new ArrayList<Building>();
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet()) {
            Building building = entry.getValue();
            // do something with key and/or tab
            buildingsList.add(building);
        }
        return buildingsList;
    }

    public Building findById(Long id){
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet()) {
            Building building = entry.getValue();
            if (Objects.equals(entry.getKey(), id)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void update(Long id, Building newBuilding){
        if (findById(id) == null)
            return;
        newBuilding.setId(id);
        buildingsDict.put(id, newBuilding);
    }

    public void update(Long id, Building building, Floor newFloor){
        if (findById(building.getId()) == null)
            return;
        else if (findLocationById(id) == null)
            return;

        Long buildingID = building.getId();

        for(int i = 0; i < building.getFloors().size(); i++)
        {
            if (Objects.equals(building.getFloors().get(i).getId(), id))
            {
                building.getFloors().set(Math.toIntExact(id), newFloor);
                break;
            }
        }

        buildingsDict.put(buildingID, building);
    }

    public void update(Long id, Building building, Floor floor, Room newRoom){
        if (findById(building.getId()) == null)
            return;
        else if (findLocationById(floor.getId()) == null)
            return;
        else if (findLocationById(id) == null)
            return;

        Long buildingID = building.getId();

        for(int i = 0; i < building.getFloors().size(); i++)
        {
            outerloop:
            if (Objects.equals(building.getFloors().get(i), floor))
            {
                for(int j = 0; j < floor.getRooms().size(); j++)
                {
                    if (Objects.equals(floor.getRooms().get(j).getId(), id))
                    {
                        floor.getRooms().set(Math.toIntExact(id), newRoom);
                        break outerloop;
                    }
                }
            }
        }

        buildingsDict.put(buildingID, building);
    }

    public Location findLocationById(Long id){
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet()) {
            Building building = entry.getValue();
            if (Objects.equals(building.getId(), id)) {
                return building;
            }
            for (Floor floor : building.getFloors()) {
                if (Objects.equals(floor.getId(), id)) {
                    return floor;
                }
                for (Room room : floor.getRooms()) {
                    if (Objects.equals(room.getId(), id)) {
                        return room;
                    }
                }
            }
        }
        return null;
    }

    public void deleteById(Long aLong) {
        buildingsDict.remove(aLong);
    }

    public void delete(Building building) {
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet()) {
            if (entry.getValue() == building){
                buildingsDict.remove(entry.getKey());
                return;
            }
        }
    }

    public void deleteAll() {

    }

    public Building save(Building building) {
        long newId = getNextKey();

        for (Floor floor : building.getFloors())
        {
            for (Room room : floor.getRooms()){
                room.setId(newId);
                newId += 1;
            }
            floor.setId(newId);
            newId += 1;
        }
        building.setId(newId);

        buildingsDict.put(newId, building);
        return building;
    }

    private Long getNextKey(){
        long maxKey = 0L;
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet())
        {
            if (entry.getKey() > maxKey)
            {
                maxKey = entry.getKey() + 1;
            }
        }
        return maxKey;
    }

}
