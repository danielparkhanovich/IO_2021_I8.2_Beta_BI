package Structures;


public class Building extends Location {

    private Floor[] floors;

    public Building(int id, Floor[] floors) {
        super(id);
        this.floors = floors;
    }

    public Building(int id, String name, Floor[] floors) {
        super(id, name);
        this.floors = floors;
    }
}
