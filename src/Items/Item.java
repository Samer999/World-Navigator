package Items;

import java.io.Serializable;
import java.util.Objects;

public abstract class Item implements Serializable {

  private int price;

  public Item(int price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price value is not valid!");
    }

    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public abstract boolean equalToUse(Object o);

  public abstract String toString();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return price == item.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
