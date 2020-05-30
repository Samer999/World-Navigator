package Tests.RoomObjects;

import Directions.Direction;
import Map.RoomObjects.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    Door door;


    @BeforeEach
    void setUp() {
        door = new Door();
    }

    @Test
    void setAndGetRoom() {
        Room room1 = new Room();
        Room room2 = new Room();

        door.setRoom(Direction.NORTH, room1);
        door.setRoom(Direction.SOUTH, room2);

        assertEquals(door.getRoom(Direction.NORTH), room1);
        assertEquals(door.getRoom(Direction.SOUTH), room2);
    }


}