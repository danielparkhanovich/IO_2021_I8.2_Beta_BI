package com.example.restservice;

import com.example.restservice.Structures.Building;
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
        long newId = getMaxKey() + 1;
        buildingsDict.put(newId, building);
        return building;
    }

    private Long getMaxKey(){
        long maxKey = 0L;
        for (HashMap.Entry<Long, Building> entry : buildingsDict.entrySet())
        {
            if (entry.getKey() > maxKey)
            {
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

}
