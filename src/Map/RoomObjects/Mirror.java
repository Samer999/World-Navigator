package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;
import java.io.Serializable;

public class Mirror implements LootHidder, Checkable, RoomObject, Serializable {

  private OneKeyLoot key;

  public Mirror() {
    key = new OneKeyLoot();
  }

  public Mirror(Key key) {

    if (key == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    this.key = new OneKeyLoot(key);
  }

  @Override
  public String check() {
    return "checking behind the mirror...";
  }

  @Override
  public Loot getLoot() {
    return key;
  }

  @Override
  public void loot(Player player) {
    key.loot(player);
  }

  @Override
  public String look() {
    return "You See a silhouette of you";
  }
}
