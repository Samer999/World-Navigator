package Map.RoomObjects;

import Items.Key;

public class Door extends Entryway {


  public Door() {
  }

  public Door(Key lockKey) {
    super(lockKey);
  }

  @Override
  public String check() {
    if (!isUnlocked()) {
      return "Door is locked, " + getKeyName() + " key is needed to unlock";
    } else if (isOpen()) {
      return "Door is open";
    } else {
      return "The door is unlocked, but you need to open it to go through it";
    }
  }

  @Override
  public String look() {
    return "Door";
  }
}
