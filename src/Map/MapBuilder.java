package Map;

import Directions.Direction;
import Map.RoomObjects.Room;

public class MapBuilder {

  private Room startRoom;
  private Room goalRoom;
  private int timeToFinish;
  private int initialGold;
  private Direction playerFacingDirection;

  public MapBuilder setStartRoom(Room startRoom) {

    if (startRoom == null) {
      throw new NullPointerException("start room value is null!");
    }

    this.startRoom = startRoom;
    return this;
  }

  public MapBuilder setGoalRoom(Room goalRoom) {

    if (goalRoom == null) {
      throw new NullPointerException("goal room value is null!");
    }

    this.goalRoom = goalRoom;
    return this;
  }

  public MapBuilder setTimeToFinish(int timeToFinish) {

    if (timeToFinish < 0) {
      throw new IllegalArgumentException("time to finish value is invalid!");
    }

    this.timeToFinish = timeToFinish;
    return this;
  }

  public MapBuilder setInitialGold(int initialGold) {

    if (initialGold < 0) {
      throw new IllegalArgumentException("initial gold value is invalid!");
    }

    this.initialGold = initialGold;
    return this;
  }

  public MapBuilder setPlayerFacingDirection(Direction playerFacingDirection) {

    if (playerFacingDirection == null) {
      throw new NullPointerException("player facing direction value is null!");
    }

    this.playerFacingDirection = playerFacingDirection;
    return this;
  }

  public Map buildMap() {
    return new Map(startRoom, goalRoom, timeToFinish, initialGold, playerFacingDirection);
  }
}
