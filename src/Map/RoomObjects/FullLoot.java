package Map.RoomObjects;

import Items.Item;
import PlayerInfo.ItemStatus;
import PlayerInfo.Player;

import java.io.Serializable;

public class FullLoot implements Loot, Serializable {

    private int goldLoot;
    private ItemStatus lootStatus;

    public FullLoot() {
        this(0);
    }

    public FullLoot(int goldLoot) {
        if (goldLoot < 0)
            throw new IllegalArgumentException("gold amount is negative!");

        this.goldLoot = goldLoot;

        lootStatus = new ItemStatus();
    }

    public void addItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item value is null!");

        lootStatus.addItem(item);
    }

    public void addGold(int goldLoot) {
        if (goldLoot < 0)
            throw new IllegalArgumentException("gold amount is negative!");

        this.goldLoot += goldLoot;
    }

    public void lootGold(Player player) {

        if (player == null)
            throw new IllegalArgumentException("player value is null!");

        player.giveGold(goldLoot);
        System.out.println(goldLoot + " gold was acquired");
        goldLoot = 0;
    }

    public void lootItems(Player player) {

        if (player == null)
            throw new IllegalArgumentException("player value is null!");

        int lastIndexInList = lootStatus.numberOfItems() - 1;

        if (lastIndexInList == -1) {
            System.out.println("no items are here");
            return;
        }

        System.out.println("this is the looted items\n" + lootStatus.getItemsStatus());

        while (lastIndexInList != -1) {

            Item lootedItem = lootStatus.getItemByIndex(lastIndexInList);
            player.giveItem(lootedItem);
            lootStatus.removeItem(lootedItem);

            lastIndexInList--;
        }

    }

    public void loot(Player player) {
        lootGold(player);
        lootItems(player);
    }

}
