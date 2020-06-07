package Map.RoomObjects;

import Directions.Direction;
import Items.Light;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Objects;

public class Room implements Serializable {

  // ex : roomObjects.get(NORTH) gives us the roomObject on the northern wall
  private EnumMap<Direction, RoomObject> roomObjects;
  // every room could have a light inside it and it could be from any type of lights
  private Light roomLight;

  public Room() {
    roomObjects = new EnumMap(Direction.class);

    // default values for room objects
    roomObjects.put(Direction.NORTH, new PlainWall());
    roomObjects.put(Direction.WEST, new PlainWall());
    roomObjects.put(Direction.EAST, new PlainWall());
    roomObjects.put(Direction.SOUTH, new PlainWall());
  }

  public Room(Light roomLight) {
    this();
    if (roomLight == null) {
      throw new IllegalArgumentException("room light switch value is null!");
    }

    this.roomLight = roomLight;
  }

  public void addRoomObject(Direction direction, RoomObject roomObject) {

    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    if (roomObject == null) {
      throw new IllegalArgumentException("room object value is null!");
    }

    roomObjects.put(direction, roomObject);
  }

  public RoomObject getRoomObject(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    return roomObjects.get(direction);
  }

  public boolean isLightSwitchAvailable() {
    return roomLight != null;
  }

  public boolean isLightSwitchOn() {
    if (roomLight == null) {
      return false;
    }

    return roomLight.isLightOn();
  }

  public void switchLightSwitch() {
    if (!isLightSwitchAvailable()) {
      System.out.println("There is no switch to switch!");
    }

    roomLight.toggle();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return roomObjects.equals(room.roomObjects) && roomLight.equals(room.roomLight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roomObjects, roomLight);
  }
}
