package Map.RoomObjects;

import Items.Key;
import PlayerInfo.Player;

import java.io.Serializable;

public class OneKeyLoot implements Loot, Serializable {

    private Key key;

    public OneKeyLoot(){

    }

    public OneKeyLoot(Key key) {
        if (key == null)
            throw new IllegalArgumentException("key value is null!");

        this.key = key;
    }

    public void loot(Player player) {

        if (player == null)
            throw new IllegalArgumentException("player value is null!");

        if (key == null) {
            System.out.println("No Key is hidden here");
            return;
        }

        player.giveItem(key);
        System.out.println("the " + key.getName() + " key was acquired");
        key = null;
    }

}
