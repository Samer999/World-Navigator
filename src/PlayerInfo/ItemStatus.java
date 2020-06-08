package PlayerInfo;

import Items.Item;
import java.io.Serializable;
import java.util.ArrayList;

public class ItemStatus implements Serializable {

  private ArrayList<Item> itemList;

  public ItemStatus() {
    itemList = new ArrayList();
  }

  public void addItem(Item item) {
    if (item == null) {
      throw new NullPointerException("item value is null");
    }

    itemList.add(item);
  }

  public void removeItem(Item item) {
    if (item == null) {
      throw new NullPointerException("item value is null");
    }

    itemList.remove(item);
  }

  public boolean isValidIndex(int index) {
    if (index < 0 || index >= itemList.size()) {
      return false;
    }

    return true;
  }

  public int numberOfItems() {
    return itemList.size();
  }

  public Item getItemByIndex(int index) {
    if (isValidIndex(index) == false) {
      throw new IndexOutOfBoundsException("This is not a valid index!");
    }
    return itemList.get(index);
  }

  public boolean contains(Item item) {
    if (item == null) {
      throw new NullPointerException("item value is null!");
    }

    return itemList.contains(item);
  }

  public StringBuilder getItemsStatus() {

    StringBuilder status = new StringBuilder("Item status : \n");

    for (int i = 0; i < itemList.size(); i++) {
      status.append("\t" + (i) + " : " + itemList.get(i) + "\n");
    }

    return status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemStatus that = (ItemStatus) o;

    for (Item item : that.itemList) if (!itemList.contains(item)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int hash = 31;
    for (Item item : itemList) hash = ((hash + item.hashCode()) * 31) % Integer.MAX_VALUE;

    return hash;
  }
}
