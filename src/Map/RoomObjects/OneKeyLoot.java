package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;
import java.io.Serializable;
import java.util.Objects;

/** OneKeyLoot is a type of loot that is just a Key */
public class OneKeyLoot implements Loot, Serializable {

  private Key key;

  public OneKeyLoot() {}

  public OneKeyLoot(Key key) {
    if (key == null) {
      throw new NullPointerException("key value is null!");
    }

    this.key = key;
  }

  public void loot(Player player) {

    if (player == null) {
      throw new NullPointerException("player value is null!");
    }

    if (key == null) {
      System.out.println("No Key is hidden here");
      return;
    }

    player.giveItem(key);
    System.out.println("the " + key.getName() + " key was acquired");
    key = null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OneKeyLoot that = (OneKeyLoot) o;
    return key.equals(that.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key);
  }
}
