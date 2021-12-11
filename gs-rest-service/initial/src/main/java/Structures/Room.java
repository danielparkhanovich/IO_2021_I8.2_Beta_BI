package Structures;


public class Room extends Location {

    private float area;
    private float cube;
    private float heating;
    private float light;

    public Room(int id) {
        super(id);
    }

    public Room(int id, String name) {
        super(id, name);
    }

    public Room(int id, String name, float area, float cube, float heating, float light) {
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
