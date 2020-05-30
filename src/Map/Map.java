package Map;

import Directions.Direction;
import Map.RoomObjects.Room;

import java.io.Serializable;

public class Map implements Serializable {

    private Room startRoom;
    private Room goalRoom;
    private int timeToFinish;
    private int initialGold;
    private Direction playerFacingDirection;

    public Map(Room startRoom, Room goalRoom, int timeToFinish, int initialGold, Direction playerFacingDirection) {

        if (startRoom == null)
            throw new IllegalArgumentException("start room value is null!");

        if (goalRoom == null)
            throw new IllegalArgumentException("goa room value is null!");

        if (timeToFinish < 0)
            throw new IllegalArgumentException("time to finish value is invalid");

        if (initialGold < 0)
            throw new IllegalArgumentException("initial gold value is invalid");

        if (playerFacingDirection == null)
            throw new IllegalArgumentException("player facing direction value is null!");

        this.startRoom = startRoom;
        this.goalRoom = goalRoom;
        this.timeToFinish = timeToFinish;
        this.initialGold = initialGold;
        this.playerFacingDirection = playerFacingDirection;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public Room getGoalRoom() {
        return goalRoom;
    }

    public int getTimeToFinish() {
        return timeToFinish;
    }

    public int getInitialGold() {
        return initialGold;
    }

    public Direction getPlayerFacingDirection(){
        return playerFacingDirection;
    }


}
