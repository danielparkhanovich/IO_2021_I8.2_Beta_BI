package com.example.restservice;

import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBuilding {

    @Test
    public void testingArea1() {
        Room room = new Room("Room1", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room2 = new Room("Room2", 65.2f, 130.3f, 240.24f, 300.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room);
        roomArrayList.add(room2);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcArea() == 25.6f + 65.2f);
    }

    @Test
    public void testingArea2() {
        Room room3 = new Room("Room3", 25.6f, 70.3f, 140.24f, 123.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room3);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertEquals(25.6f, Home.calcArea() );
    }

    @Test
    public void testingArea3() {
        Room room4 = new Room("Room3", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room5 = new Room("Room5", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room6 = new Room("Room6", 25.6f, 70.3f, 140.24f, 123.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        roomArrayList.add(room4);
        roomArrayList.add(room5);
        roomArrayList.add(room6);
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcArea() == 25.6f + 25.6f + 25.6f);
    }

    @Test
    public void testingArea4() {
        Room room4 = new Room("Room3", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room5 = new Room("Room5", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room6 = new Room("Room6", 25.6f, 70.3f, 140.24f, 123.2f );
        Room room7 = new Room("Room7", 25.6f, 70.3f, 140.24f, 123.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room4);
        roomArrayList.add(room5);
        roomArrayList.add(room6);
        roomArrayList.add(room7);
        ArrayList<Floor> flat1ArrayList = new ArrayList<Floor>();
        flat1ArrayList.add(new Floor(roomArrayList));
        ArrayList<Floor> flat2ArrayList = new ArrayList<Floor>();
        Building Home = new Building(flat1ArrayList);
        flat2ArrayList.add(new Floor(roomArrayList));
        Assertions.assertTrue(Home.calcArea() == 25.6f * 3 + 25.6f );
    }

    @Test
    public void testingLight1() {
        Room room4 = new Room("Room4", 62.3f, 98.3f, 54.24f, 524.2f );
        Room room5 = new Room("Room5", 67.2f, 88.8f, 86.9f, 125.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room4);
        roomArrayList.add(room5);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertTrue(Home.calcLight() == 524.2f + 125.2f);
    }

    @Test
    public void testingLight2() {
        Room room6 = new Room("Room6", 62.3f, 98.3f, 54.24f, 524.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room6);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertEquals(524.2f,Home.calcLight() );
    }

    @Test
    public void testingLight3() {
        Room room7 = new Room("Room6", 62.3f, 98.3f, 54.24f, 524.2f );
        Room room8 = new Room("Room6", 62.3f, 98.3f, 54.24f, 524.2f );
        Room room9 = new Room("Room6", 62.3f, 98.3f, 54.24f, 524.2f );
        ArrayList<Room> roomArrayList = new ArrayList<Room>();
        roomArrayList.add(room7);
        roomArrayList.add(room8);
        roomArrayList.add(room9);
        ArrayList<Floor> flatArrayList = new ArrayList<Floor>();
        flatArrayList.add(new Floor(roomArrayList));
        Building Home = new Building(flatArrayList);
        Assertions.assertEquals(524.2f*3,Home.calcLight() );
    }

    @Test
    public void testingLightingPower1() {
        Room room7 = new Room("Room7", 125f, 98.3f, 54.24f, 500.0f );
        Assertions.assertTrue(room7.calcLightingPower() == 4.0f);
    }

    @Test
    public void testingLightingPower2() {
        Room room8 = new Room("Room8", 20f, 98.3f, 54.24f, 100.0f );
        Assertions.assertEquals(5.0f,room8.calcLightingPower() );
    }

    @Test
    public void testingLightingPower3() {
        Room room9 = new Room("Room8", 45.2f, 98.3f, 54.24f, 135.6f );
        Assertions.assertEquals(3.0f,room9.calcLightingPower() );
    }



}
