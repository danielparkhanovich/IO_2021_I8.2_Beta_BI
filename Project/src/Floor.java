


public class Floor extends Location {

    private Room[] rooms;

    public Floor(int id, Room[] rooms) {
        super(id);
        this.rooms = rooms;
    }

    public Floor(int id, String name, Room[] rooms) {
        super(id, name);
        this.rooms = rooms;
    }
}
