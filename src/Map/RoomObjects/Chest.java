package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;

public class Chest extends Lockable implements RoomObject, Checkable, LootHidder {

  private FullLoot loot;

  public Chest() {

  }

  public Chest(Key lockKey) {
    super(lockKey);
  }

  @Override
  public Loot getLoot() {
    return loot;
  }

  public void setLoot(FullLoot loot) {
    if (loot == null) {
      throw new IllegalArgumentException("this loot value is null!");
    }
    this.loot = loot;
  }

  @Override
  public String look() {
    return "Chest";
  }

  @Override
  public String check() {
    if (!isUnlocked()) {
      return "Chest is locked, " + getKeyName() + " key is needed to unlock";
    } else if (isOpen()) {
      return "Chest is opened and looted";
    } else {
      return "checking the chest...";
    }
  }

  @Override
  public void loot(Player player) {
    if (isUnlocked()) {
      loot.loot(player);
    }
  }
}
