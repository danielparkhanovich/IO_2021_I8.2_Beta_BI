package com.example.restservice.Structures;

import javax.persistence.Entity;

@Entity
public class Room extends Location {

    private float area;
    private float cube;
    private float heating;
    private float light;

    public Room() {
        super();
    }

    public Room(String name) {
        super(name);
    }

    public Room(String name, float area, float cube, float heating, float light) {
        super(name);
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

    public void setArea(float area){
        this.area = area;
    }

    public void setCube(float cube){
        this.cube = cube;
    }

    public void setHeating(float heating){
        this.heating = heating;
    }

    public void setLight(float light){
        this.light = light;
    }

    @Override
    public String toString(String interspace) {
        interspace += "---> ";
        String msg = super.toString(interspace);
        msg += interspace + "area: " + Float.toString(area) + "\n"
                + interspace + "cube: " + Float.toString(cube) + "\n"
                + interspace + "heating: " + Float.toString(heating) + "\n"
                + interspace + "light: " + Float.toString(light);
        return msg;
    }

    @Override
    public float calcArea() {
        return getArea();
    }
}
