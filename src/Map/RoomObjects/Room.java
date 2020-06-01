package Map.RoomObjects;


import Directions.Direction;
import Items.Light;
import java.io.Serializable;
import java.util.EnumMap;

public class Room implements Serializable {

  // ex : wallObjects.get(NORTH) gives us the wallObject on the northern wall
  private EnumMap<Direction, RoomObject> wallObjects;
  private Light roomLight;


  public Room() {
    wallObjects = new EnumMap(Direction.class);

    //default values for room objects
    wallObjects.put(Direction.NORTH, new PlainWall());
    wallObjects.put(Direction.WEST, new PlainWall());
    wallObjects.put(Direction.EAST, new PlainWall());
    wallObjects.put(Direction.SOUTH, new PlainWall());
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

    wallObjects.put(direction, roomObject);
  }

  public RoomObject getWallObject(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    return wallObjects.get(direction);
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
}
