package PlayerInfo;

import Items.Item;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class Trader implements Serializable {

  private ItemStatus itemStatus;
  private GoldStatus goldStatus;

  public Trader(int GoldAmount) {
    itemStatus = new ItemStatus();
    goldStatus = new GoldStatus(GoldAmount);
  }

  public void giveItem(Item item) {
    itemStatus.addItem(item);
  }

  public void giveGold(int amount) {
    goldStatus.deposit(amount);
  }

  public void takeAwayItem(Item item) {
    itemStatus.removeItem(item);
  }

  public void takeAwayGold(int amount) {
    goldStatus.withdraw(amount);
  }

  public int getGoldBalance() {
    return goldStatus.getBalance();
  }

  public boolean isValidItemIndex(int index) {
    return itemStatus.isValidIndex(index);
  }

  public Item getItemByIndex(int index) {
    return itemStatus.getItemByIndex(index);
  }

  private boolean canSellItemTo(Trader trader, Item item) {
    if (trader == null) {
      throw new IllegalArgumentException("trader value is null!");
    }

    if (item == null) {
      throw new IllegalArgumentException("item value is null!");
    }

    if (itemStatus.contains(item) == false) {
      throw new NoSuchElementException("this item is not with this trader!");
    }

    if (item.getPrice() > trader.getGoldBalance()) {
      return false;
    }

    return true;
  }

  public final void sellItem(Trader trader, Item item) {

    if (trader == null) {
      throw new IllegalArgumentException("trader value is null!");
    }

    if (item == null) {
      throw new IllegalArgumentException("item value is null!");
    }

    if (!canSellItemTo(trader, item)) {
      cancelSelling();
      trader.cancelBuying();
      return;
    }

    proceedSelling(item);
    trader.proceedBuying(item);
  }

  public final void buyItem(
      Trader trader, Item item) { // This Template Method calls the other Template Method

    if (trader == null) {
      throw new IllegalArgumentException("trader value is null!");
    }

    if (item == null) {
      throw new IllegalArgumentException("item value is null!");
    }

    trader.sellItem(this, item);
  }

  public abstract void cancelBuying();

  public abstract void cancelSelling();

  public abstract void proceedBuying(Item item);

  public abstract void proceedSelling(Item item);

  public StringBuilder getStatus() {
    StringBuilder status = goldStatus.getGoldStatus();
    status.append(itemStatus.getItemsStatus());
    return status;
  }

  public StringBuilder getItemStatus() {
    return itemStatus.getItemsStatus();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trader trader = (Trader) o;
    return itemStatus.equals(trader.itemStatus) && goldStatus.equals(trader.goldStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemStatus, goldStatus);
  }
}
