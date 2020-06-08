package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;
import java.io.Serializable;
import java.util.Objects;

public class Painting implements LootHider, Checkable, RoomObject, Serializable {

  private OneKeyLoot keyLoot;

  public Painting() {
    keyLoot = new OneKeyLoot();
  }

  public Painting(Key keyLoot) {

    if (keyLoot == null) {
      throw new NullPointerException("key value is null!");
    }

    this.keyLoot = new OneKeyLoot(keyLoot);
  }

  @Override
  public String check() {
    return "checking behind the painting...";
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
    return "Painting";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Painting painting = (Painting) o;
    return keyLoot.equals(painting.keyLoot);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyLoot);
  }
}
