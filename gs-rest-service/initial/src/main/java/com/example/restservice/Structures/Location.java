package com.example.restservice.Structures;

import javax.persistence.*;

@Entity
public abstract class Location {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;

    public Location(){
    }

    public Location(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(String interspace) {
        return interspace + "Location id: " + Long.toString(id) + " " + name + "\n"
                + interspace + "Type: " + getClass() + "\n";
    }

    public abstract float calcArea();

    public abstract float calcLight();

    public abstract float calcLightingPower();

    public abstract float calcCube();

    public abstract float calcEnergy();
}
