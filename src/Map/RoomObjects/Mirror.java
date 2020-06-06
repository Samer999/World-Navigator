package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;
import java.io.Serializable;

public class Mirror implements LootHider, Checkable, RoomObject, Serializable {

  private OneKeyLoot keyLoot;

  public Mirror() {
    keyLoot = new OneKeyLoot();
  }

  public Mirror(Key keyLoot) {

    if (keyLoot == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    this.keyLoot = new OneKeyLoot(keyLoot);
  }

  @Override
  public String check() {
    return "checking behind the mirror...";
  }

  @Override
  public Loot getLoot() {
    return keyLoot;
  }

  @Override
  public void loot(Player player) {
    keyLoot.loot(player);
  }

  @Override
  public String look() {
    return "You See a silhouette of you";
  }
}
