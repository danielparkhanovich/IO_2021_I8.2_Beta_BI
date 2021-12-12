package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Room extends Location {

    private float area;
    private float cube;
    private float heating;
    private float light;

    public Room(Long id) {
        super(id);
    }

    public Room(Long id, String name) {
        super(id, name);
    }

    public Room(Long id, String name, float area, float cube, float heating, float light) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public float getArea(){
        return area;
    }

    public float getCube(){
        return cube;
    }

    public float getHeating(){
        return heating;
    }

    public float getLight(){
        return light;
    }

}
