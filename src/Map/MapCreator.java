package Map;

import Directions.Direction;
import Items.FlashLight;
import Items.Key;
import Map.RoomObjects.Chest;
import Map.RoomObjects.Door;
import Map.RoomObjects.FullLoot;
import Map.RoomObjects.Mirror;
import Map.RoomObjects.Painting;
import Map.RoomObjects.Room;
import Map.RoomObjects.Seller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MapCreator {


  public static void main(String[] args) {

    Mirror mirror1 = new Mirror();
    Painting painting1 = new Painting(new Key(11, "Zed"));
    Mirror mirror2 = new Mirror(new Key(23, "Final"));

    Chest chest1 = new Chest(new Key(10, "Susuu"));
    FullLoot fullLoot1 = new FullLoot();
    fullLoot1.addItem(new Key(19, "Alpha"));
    fullLoot1.addItem(new Key(3, "LOL"));
    fullLoot1.addItem(new FlashLight(4));
    fullLoot1.addGold(40);
    chest1.setLoot(fullLoot1);

    Chest chest2 = new Chest();
    FullLoot fullLoot2 = new FullLoot();
    fullLoot2.addItem(new Key(2, "BigO"));
    fullLoot2.addItem(new FlashLight(27));
    fullLoot2.addItem(new Key(4, "PS5"));
    fullLoot2.addGold(12);
    chest2.setLoot(fullLoot2);

    Seller seller1 = new Seller();
    seller1.giveItem(new Key(31, "Omega"));
    seller1.giveItem(new Key(22, "Susuu"));
    seller1.giveItem(new FlashLight(3));
    seller1.giveItem(new Key(10, "PS3"));

    Seller seller2 = new Seller();
    seller2.giveItem(new FlashLight(12));
    seller2.giveItem(new Key(31, "Alpha"));
    seller2.giveItem(new Key(22, "Amer"));
    seller2.giveItem(new Key(10, "SkullCandy"));

    Door door1 = new Door(new Key(20, "Alpha"));
    Door door2 = new Door();
    Door door3 = new Door(new Key(10, "BigO"));
    Door door4 = new Door(new Key(5, "Final"));

    Room start = new Room(new FlashLight(12));
    door1.setRoom(Direction.EAST, start);
    start.addRoomObject(Direction.NORTH, chest1);
    start.addRoomObject(Direction.WEST, door1);
    start.addRoomObject(Direction.SOUTH, seller1);

    Room room2 = new Room();
    door1.setRoom(Direction.WEST, room2);
    door2.setRoom(Direction.NORTH, room2);
    room2.addRoomObject(Direction.NORTH, chest2);
    room2.addRoomObject(Direction.EAST, door1);
    room2.addRoomObject(Direction.SOUTH, door2);
    room2.addRoomObject(Direction.WEST, mirror1);

    Room room3 = new Room(new FlashLight(0));
    door2.setRoom(Direction.SOUTH, room3);
    door3.setRoom(Direction.EAST, room3);
    room3.addRoomObject(Direction.NORTH, door2);
    room3.addRoomObject(Direction.EAST, painting1);
    room3.addRoomObject(Direction.SOUTH, seller2);
    room3.addRoomObject(Direction.WEST, door3);

    Room room4 = new Room();
    door3.setRoom(Direction.WEST, room4);
    door4.setRoom(Direction.NORTH, room4);
    room4.addRoomObject(Direction.NORTH, mirror2);
    room4.addRoomObject(Direction.EAST, door3);
    room4.addRoomObject(Direction.SOUTH, door4);

    Room end = new Room();
    door4.setRoom(Direction.SOUTH, end);
    end.addRoomObject(Direction.NORTH, door4);

    MapBuilder mapBuilder = new MapBuilder();
    mapBuilder.setStartRoom(start);
    mapBuilder.setGoalRoom(end);
    mapBuilder.setPlayerFacingDirection(Direction.EAST);
    mapBuilder.setInitialGold(33);
    mapBuilder.setTimeToFinish(5 * 60);

    Map map = mapBuilder.buildMap();

    try {
      FileOutputStream fileOutputStream = new FileOutputStream("resources/maps/5Rooms 5min.ser");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(map);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
/* example
* ////creating the 3Room 5min Map////

        Mirror mirror1 = new Mirror(new Key(5, "Susuu"));
        Painting painting1 = new Painting();

        FullLoot fullLoot = new FullLoot();
        fullLoot.addGold(54);
        fullLoot.addItem(new Key(10, "Samer"));
        fullLoot.addItem(new FlashLight(14));
        fullLoot.addItem(new Key(6, "Zed"));
        fullLoot.addItem(new Key(3, "Amer"));

        Chest chest1 = new Chest(new Key(0, "Susuu"));
        chest1.setLoot(fullLoot);

        Seller seller1 = new Seller();
        seller1.giveItem(new Key(10, "BigGoal"));
        seller1.giveItem(new Key(5, "SmallO"));
        seller1.giveItem(new FlashLight(40));

        Door door1 = new Door();
        Door door2 = new Door(new Key(0, "BigGoal"));

        Room start = new Room(new FlashLight(19));
        Room room2 = new Room();
        Room end = new Room();

        start.addRoomObject(Direction.WEST, door2);
        start.addRoomObject(Direction.EAST, door1);
        start.addRoomObject(Direction.SOUTH, mirror1);
        start.addRoomObject(Direction.NORTH, chest1);

        room2.addRoomObject(Direction.WEST, door1);
        room2.addRoomObject(Direction.EAST, painting1);
        room2.addRoomObject(Direction.SOUTH, seller1);

        end.addRoomObject(Direction.EAST, door2);

        door1.setRoom(Direction.WEST, start);
        door1.setRoom(Direction.EAST, room2);

        door2.setRoom(Direction.EAST, start);
        door2.setRoom(Direction.WEST, end);

        MapBuilder mapBuilder = new MapBuilder();

        mapBuilder.setStartRoom(start);
        mapBuilder.setGoalRoom(end);
        mapBuilder.setTimeToFinish(5 * 60);
        mapBuilder.setInitialGold(10);
        mapBuilder.setPlayerFacingDirection(Direction.SOUTH);

        Map map = mapBuilder.buildMap();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("resources/maps/3Rooms 5min.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

*
* */