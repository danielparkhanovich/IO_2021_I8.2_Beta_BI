package Structures;


public abstract class Location {

    private int id;
    private String name;

    public Location(int id){
        this.id = id;
    }

    public Location(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
