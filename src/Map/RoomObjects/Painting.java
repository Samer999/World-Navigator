package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;
import java.io.Serializable;

public class Painting implements LootHider, Checkable, RoomObject, Serializable {

  private OneKeyLoot key;

  public Painting() {
    key = new OneKeyLoot();
  }

  public Painting(Key key) {

    if (key == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    this.key = new OneKeyLoot(key);
  }

  @Override
  public String check() {
    return "checking behind the painting...";
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
    return "Painting";
  }
}
