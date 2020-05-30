package Map.RoomObjects;

import Directions.Direction;
import Items.Key;

import java.util.EnumMap;

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
        if (direction == null)
            throw new IllegalArgumentException("direction value is null!");

        if (room == null)
            throw new IllegalArgumentException("room value is null!");

        nextRoom.put(direction, room);
    }

    public Room getRoom(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("direction value is null!");

        return nextRoom.get(direction);
    }
}