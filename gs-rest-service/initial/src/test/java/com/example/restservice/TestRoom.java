package com.example.restservice;

import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestRoom {
    @Test
    public void testingCalcCube1() {
        Room room = new Room("Room1", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room2 = new Room("Room2", 65.2f, 130.3f, 240.24f, 300.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        roomArrayList.add(room2);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcCube() == 70.3f + 130.3f);

    }
    @Test
    public void testingCalcCube2() {
        Room room = new Room("Room1", 25.6f, 70.3f, 140.24f, 123.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertEquals(70.3f,Home.calcCube() );

    }

    @Test
    public void testingCalcCube3() {
        Room room = new Room("Room1", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room2 = new Room("Room2", 65.2f, 130.3f, 240.24f, 300.2f );
        Room room3 = new Room("Room3", 40.7f, 144.8f, 228.24f, 133.7f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        roomArrayList.add(room2);
        roomArrayList.add(room3);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcCube() == 70.3f + 130.3f+ 144.8F);

    }


    @Test
    public void testingCalcCube4() {
        Room room = new Room("Room1", 25.6f, 100.1f, 140.24f, 123.2f );
        Room room2 = new Room("Room2", 65.2f, 200.2f, 240.24f, 300.2f );
        Room room3 = new Room("Room3", 40.7f, 300.3f, 228.24f, 133.7f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        roomArrayList.add(room2);
        roomArrayList.add(room3);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcCube() == 600.6f);
    }

    @Test
    public void testingCalcCube5() {
        Room room = new Room("Room1", 25.6f, 123f, 140.24f, 123.2f );
        Room room2 = new Room("Room2", 65.2f, 12.3f, 240.24f, 300.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        roomArrayList.add(room2);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcCube() == 135.3f);

    }

    @Test
    public void testingCalcEnergy1() {
        Room room = new Room("Room1", 56f, 213f, 140.24f, 24560.0f );
        Assertions.assertEquals(0.65840375f,room.calcEnergy() );

    }

    @Test
    public void testingCalcEnergy2() {
        Room room = new Room("Room2", 25.0f, 50.0f, 140.24f, 1500.0f );
        Assertions.assertEquals(2.8048f,room.calcEnergy() );

    }

    @Test
    public void testingCalcEnergy3() {
        Room room = new Room("Room3", 25.0f, 50.0f, 140.24f, 1500.0f );
        Assertions.assertEquals(2.8048f,room.calcEnergy() );

    }

    @Test
    public void testingCalcEnergy4() {
        Room room = new Room("Room4", 10f, 100f, 140.24f, 100000.0f );
        Assertions.assertEquals(1.4024f,room.calcEnergy() );

    }

    @Test
    public void testingCalcEnergy5() {
        Room room = new Room("Room5", 80f, 512f, 8456f, 5465.0f );
        Assertions.assertEquals(16.515625f,room.calcEnergy() );

    }

}
