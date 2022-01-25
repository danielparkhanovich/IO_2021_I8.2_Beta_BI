package com.example.restservice.Structures;

import javax.persistence.Entity;

/**
 * Class room contains all information about the room.
 */


@Entity
public class Room extends Location {

    /**
     * Area of the room, used for calculate lighting power.
     */
    private float area;
    /**
     * Volume of the room, used for calculate energy consumption.
     */
    private float cube;
    /**
     * Heating of the room, used for calculate energy consumption.
     */
    private float heating;
    /**
     * Light of the room, used for calculate lighting power.
     */
    private float light;

    /**
     * Class constructor.
     */
    public Room() {
        super();
    }

    /**
     * Class constructor with room name as argument.
     * @param name room name
     */
    public Room(String name) {
        super(name);
    }

    /**
     * Class constructor with all fields as arguments.
     * @param name name of the room
     * @param area  area of the room
     * @param cube  volume of the room
     * @param heating  heating of the room
     * @param light  light of the room
     */

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

    /**
     * Method returns values of all class fields as String.
     *
     * @return String with all atributes of class Room
     */

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

    /**
     * Method calculate area of the room.
     *
     * @return area
     */

    @Override
    public float calcArea() {
        return getArea();
    }

    /**
     * Method calculate light in the room.
     *
     * @return light
     */

    @Override
    public float calcLight() { return getLight(); }

    /**
     * Method calculate lighting power per unit area in the room.
     *
     * @return lighting power per unit area
     */

    @Override
    public float calcLightingPower()
    {
        float area = getArea();
        if (area == 0)
            return 0;

        return (getLight()/area);
    }

    /**
     * Method calculate volume of the room.
     *
     * @return volume of the room
     */

    @Override
    public float calcCube() {
        return getCube();
    }

    /**
     * Method calculate energy consumption for heating per volume unit for the room.
     *
     * @return energy consumption per volume unit
     */

    @Override
    public float calcEnergy() { return (getHeating()/calcCube()); }




}
