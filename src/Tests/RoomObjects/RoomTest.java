package Tests.RoomObjects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Directions.Direction;
import Items.FlashLight;
import Items.Light;
import Map.RoomObjects.Mirror;
import Map.RoomObjects.PlainWall;
import Map.RoomObjects.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomTest {

  Room room;
  Light lightSwitch;

  @BeforeEach
  void setUp() {

    lightSwitch = new FlashLight(0);
    room = new Room(lightSwitch);

  }

  @Test
  void addAndGetWallObject() {
    assertTrue(room.getWallObject(Direction.NORTH) instanceof PlainWall);
    Mirror mirror = new Mirror();
    room.addRoomObject(Direction.NORTH, mirror);
    assertTrue(room.getWallObject(Direction.NORTH) == mirror);
  }

  @Test
  void isLightSwitchAvailable() {
    assertTrue(room.isLightSwitchAvailable());
    Room room2 = new Room();
    assertFalse(room2.isLightSwitchAvailable());
  }

  @Test
  void isLightSwitchOn() {
    assertFalse(room.isLightSwitchOn());
    room.switchLightSwitch();
    assertTrue(room.isLightSwitchOn());
  }

  @Test
  void switchLightSwitch() {
    room.switchLightSwitch();
    assertTrue(room.isLightSwitchOn());
    room.switchLightSwitch();
    assertFalse(room.isLightSwitchOn());
  }
}