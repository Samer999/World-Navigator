package PlayerInfo;


import Directions.Direction;
import Items.Item;
import Items.Key;
import Items.Light;
import Map.RoomObjects.Checkable;
import Map.RoomObjects.Closeable;
import Map.RoomObjects.Entryway;
import Map.RoomObjects.Lockable;
import Map.RoomObjects.LootHidder;
import Map.RoomObjects.Room;
import Map.RoomObjects.RoomObject;

public class Player extends Trader {

  private Direction facingDirection;
  private Light heldLight;
  private Room currentRoom;

  public Player() {
    super(0);
    facingDirection = Direction.NORTH;//default facing direction, it could be changed
  }


  public void setDirection(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("direction value is null!");
    }

    facingDirection = direction;
  }

  public void cancelBuying() {
    System.out.println("I don't have enough gold, sad!");
  }

  public void cancelSelling() {
    System.out.println("You don't have enough gold to buy this item, sorry!");
  }

  public RoomObject facingRoomObject() {
    return currentRoom.getWallObject(facingDirection);
  }

  public Direction getFacingDirection() {
    return facingDirection;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(Room currentRoom) {
    if (currentRoom == null) {
      throw new IllegalArgumentException("room value is null!");
    }

    this.currentRoom = currentRoom;
  }

  public boolean isHoldingLight() {
    return heldLight != null;
  }

  public void turnLeft() {
    facingDirection = Direction.turnLeft(facingDirection);
  }

  public void turnRight() {
    facingDirection = Direction.turnRight(facingDirection);
  }

  public void forward() {

    if (!(facingRoomObject() instanceof Entryway)) {
      System.out.println("This is no entry way!");
    } else if (!((Entryway) facingRoomObject()).isUnlocked()) {
      System.out.println("This entry way is locked!");
    } else if (!((Entryway) facingRoomObject()).isOpen()) {
      System.out.println("This entry way is closed!");
    } else {
      currentRoom = ((Entryway) facingRoomObject()).getRoom(facingDirection);
    }
  }


  public void backward() {

    RoomObject roomObject = currentRoom.getWallObject(Direction.oppositeDirection(facingDirection));

    if (!(roomObject instanceof Entryway)) {
      System.out.println("This is no entry way!");
    } else if (!((Entryway) roomObject).isUnlocked()) {
      System.out.println("This entry way is locked!");
    } else if (!((Entryway) roomObject).isOpen()) {
      System.out.println("This entry way is closed!");
    } else {
      currentRoom = ((Entryway) roomObject).getRoom(Direction.oppositeDirection(facingDirection));
    }

  }


  public void look() {//good
    if (!currentRoom.isLightSwitchOn() && (heldLight == null || !heldLight.isLightOn())) {
      System.out.println("Dark! Nothing to see");
      return;
    }

    System.out.println(facingRoomObject().look());
  }


  public void check() {//good

    if (!(facingRoomObject() instanceof Checkable)) {
      System.out.println("Nothing to check here!");
      return;
    }

    Checkable checkable = (Checkable) facingRoomObject();

    if (checkable == null) {
      throw new IllegalArgumentException("checkable value is null!");
    }

    System.out.println(checkable.check());

    if (checkable instanceof LootHidder) {
      ((LootHidder) checkable).loot(this);
    }

  }


  public void holdLight(Light light) {

    if (light == null) {
      throw new IllegalArgumentException("light value is null!");
    }

    if (heldLight
        != null)//if the player is holding a light, put it in inventory so he holds the other one
    {
      giveItem(heldLight);
    }

    heldLight = light;
  }

  public void dropHeldLight() {

    if (heldLight == null) {
      System.out.println("I am not holding a light source to drop it!");
    } else {
      giveItem(heldLight);
      heldLight = null;
    }
  }

  public void useHeldLight() {

    if (heldLight == null) {
      System.out.println("I am not holding a light source to use it!");
    } else {
      heldLight.toggle();
    }
  }

  public void open() {//test this
    if (!(facingRoomObject() instanceof Closeable)) {
      System.out.println("Cant open this!");
    } else {
      ((Closeable) facingRoomObject()).open();
    }
  }

  public void switchRoomLight() {
    if (currentRoom.isLightSwitchAvailable()) {
      currentRoom.switchLightSwitch();
    } else {
      System.out.println("no light switch to switch");
    }
  }


  public String itemsOfFacedTrader() {
    if (!(facingRoomObject() instanceof Trader)) {
      return "You are not facing a trader!";
    } else {
      return ((Trader) facingRoomObject()).getItemStatus().toString();
    }

  }

  public void useKey(Key key) {
    if (facingRoomObject() instanceof Lockable) {
      useKey((Lockable) facingRoomObject(), key);
    } else {
      System.out.println("What you are facing doesn't need a key!");
    }
  }

  private void useKey(Lockable lockable, Key key) {

    if (lockable == null) {
      throw new IllegalArgumentException("lockable value is null!");
    }

    if (key == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    lockable.useKey(key);
  }


  @Override
  public void proceedBuying(Item item) {

    if (item == null) {
      throw new IllegalArgumentException("item value is null!");
    }

    takeAwayGold(item.getPrice());
    giveItem(item);
    System.out.println(item + "  bought and acquired");
  }

  @Override
  public void proceedSelling(Item item) {

    if (item == null) {
      throw new IllegalArgumentException("item value is null!");
    }

    System.out.println(item + " has been sold for " + item.getPrice() + " Gold successfully!");
    takeAwayItem(item);
    giveGold(item.getPrice());
  }


  @Override
  public StringBuilder getStatus() {
    return new StringBuilder("player status :\n" +
        "player facing direction : " + facingDirection + "\n" +
        super.getStatus());
  }

  @Override
  public StringBuilder getItemStatus() {
    return new StringBuilder("Player items :\n" + super.getItemStatus());
  }


}
