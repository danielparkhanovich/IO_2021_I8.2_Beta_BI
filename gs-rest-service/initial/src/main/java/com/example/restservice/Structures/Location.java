package com.example.restservice.Structures;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Class Location describes base structure unit.
 */

@Entity
public abstract class Location {

    /**
     * Unique ID for location, used for search.
     */
    @Id
    @GeneratedValue
    protected Long id;

    /**
     * Name of location, optional.
     */
    protected String name;

    /**
     * Class constructor.
     */
    public Location(){
    }

    /**
     * Class constructor with location name as argument.
     * @param name location name
     */
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

    /**
     * Method returns values of all class fields as String.
     *
     * @return String with all atributes
     */
    public String toString(String interspace) {
        return interspace + "Location id: " + Long.toString(id) + " " + name + "\n"
                + interspace + "Type: " + getClass() + "\n";
    }

    /**
     * Base method calculate area of the location.
     *
     * @return area
     */
    public abstract float calcArea();

    /**
     * Base method calculate light in the location.
     *
     * @return light
     */
    public abstract float calcLight();

    /**
     * Base method calculate lighting power per unit area in the location.
     *
     * @return lighting power per unit area
     */
    public abstract float calcLightingPower();

    /**
     * Base method calculate volume of the location.
     *
     * @return volume of the location
     */
    public abstract float calcCube();

    /**
     * Base method calculate energy consumption for heating per volume unit for the location.
     *
     * @return energy consumption per volume unit
     */
    public abstract float calcEnergy();
}
