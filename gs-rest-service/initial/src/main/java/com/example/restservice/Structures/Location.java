package com.example.restservice.Structures;

import javax.persistence.*;

@Entity
public abstract class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

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

    public String toString(String interspace) {
        return interspace + "Location id: " + Long.toString(id) + " " + name + "\n"
                + interspace + "Type: " + getClass() + "\n";
    }
}
