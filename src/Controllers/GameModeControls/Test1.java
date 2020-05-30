package Controllers.GameModeControls;

import Directions.Direction;
import Items.FlashLight;
import Items.Key;
import Map.Map;
import Map.MapBuilder;
import Map.RoomObjects.*;
import PlayerInfo.Player;



public class Test1 {

    public static void main(String[] args) {

        Mirror mirror1 = new Mirror(new Key(13, "Mirror1 Key"));

        Painting painting1 = new Painting();

        Seller seller = new Seller();

        //seller items

        seller.giveItem(new Key(3, "Seller first key"));
        seller.giveItem(new FlashLight(5));
        seller.giveItem(new Key(10, "Seller second key"));

        Door door1 = new Door();

        Room room1 = new Room(new FlashLight(0));

        room1.addRoomObject(Direction.NORTH, mirror1);
        room1.addRoomObject(Direction.WEST, seller);
        room1.addRoomObject(Direction.SOUTH, painting1);
        room1.addRoomObject(Direction.EAST, door1);

        Mirror mirror2 = new Mirror();

        FullLoot fullLoot = new FullLoot();
        fullLoot.addItem(new Key(99, "Rare Samer"));
        fullLoot.addItem(new Key(100, "Extra Rare"));
        fullLoot.addItem(new FlashLight(120));
        fullLoot.addGold(69);

        door1.setRoom(Direction.WEST, room1);

        Chest chest = new Chest(new Key(4, "Mirror1 Key"));
        chest.setLoot(fullLoot);

        Door door2 = new Door(new Key(0, "Rare Samer"));

        Room room2 = new Room();
        room2.addRoomObject(Direction.WEST, door1);
        room2.addRoomObject(Direction.NORTH, mirror2);
        room2.addRoomObject(Direction.SOUTH, chest);
        room2.addRoomObject(Direction.EAST, door2);

        door1.setRoom(Direction.EAST, room2);


        door2.setRoom(Direction.WEST, room2);

        Room goalRoom = new Room();

        door2.setRoom(Direction.EAST, goalRoom);


        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.setInitialGold(20);
        mapBuilder.setPlayerFacingDirection(Direction.SOUTH);
        mapBuilder.setStartRoom(room1);
        mapBuilder.setGoalRoom(goalRoom);
        mapBuilder.setTimeToFinish(7);

        Map map1 = mapBuilder.buildMap();
        Map map2 = null;



        Player player = new Player();
        player.giveGold(69);
        player.giveItem(new FlashLight(20));

        OnePlayerMode gameControllerOnePlayer = new OnePlayerMode();
        gameControllerOnePlayer.setMap(mapBuilder.buildMap());

        gameControllerOnePlayer.run();
    }
}
