package Tests.RoomObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Directions.Direction;
import Map.RoomObjects.Door;
import Map.RoomObjects.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
