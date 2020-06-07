package Map.RoomObjects;

import Directions.Direction;
import Items.Key;
import java.util.EnumMap;
import java.util.Objects;

/**
 * Entryway is RoomObject that gets players from room to another, doors, portals, tunnels could be
 * considered Entryways
 */
public abstract class Entryway extends Lockable implements RoomObject, Checkable {

  private EnumMap<Direction, Room> nextRoom;

  public Entryway() {
    nextRoom = new EnumMap(Direction.class);
  }

  public Entryway(Key lockKey) {
    super(lockKey);
    nextRoom = new EnumMap(Direction.class);
  }

  public void setRoom(Direction direction, Room room) {
    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    if (room == null) {
      throw new IllegalArgumentException("room value is null!");
    }

    nextRoom.put(direction, room);
  }

  public Room getRoom(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    return nextRoom.get(direction);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entryway entryway = (Entryway) o;
    return nextRoom.equals(entryway.nextRoom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextRoom);
  }

}
