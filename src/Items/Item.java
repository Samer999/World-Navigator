package Items;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private int price;

    public Item(int price) {
        if (price < 0)
            throw new IllegalArgumentException("Price value is not valid!");

        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract boolean equalToUse(Object o);

    abstract public String toString();



}
