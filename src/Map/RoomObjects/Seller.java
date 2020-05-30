package Map.RoomObjects;



import Items.*;
import PlayerInfo.Trader;

import java.io.Serializable;


public class Seller extends Trader implements RoomObject {

    public Seller() {
        super(Integer.MAX_VALUE / 2);
    }

    public String look() {
        return "Seller";
    }

    public void cancelBuying() {
        System.out.println("I don't have enough gold :(");
    }

    public void cancelSelling() {
        System.out.println("Return when you have enough gold");
    }

    public void proceedBuying(Item item) {

        if (item == null)
            throw new IllegalArgumentException("item value is null!");

        takeAwayGold(item.getPrice());
        giveItem(item);
    }

    public void proceedSelling(Item item) {

        if (item == null)
            throw new IllegalArgumentException("item value is null!");

        takeAwayItem(item);
        giveGold(item.getPrice());
    }

    @Override
    public StringBuilder getItemStatus() {
        StringBuilder itemStatus = new StringBuilder("Seller's ").append(super.getItemStatus());

        return itemStatus;

    }
}