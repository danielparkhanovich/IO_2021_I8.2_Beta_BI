package com.example.restservice.Structures;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Location {

    private @Id @GeneratedValue Long id;
    private String name;

    public Location(Long id){
        this.id = id;
    }

    public Location(Long id, String name){
        this.id = id;
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
}
