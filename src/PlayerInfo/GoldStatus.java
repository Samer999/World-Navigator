package PlayerInfo;

import java.io.Serializable;
import java.util.Objects;

public class GoldStatus implements Serializable {

  private int balance;

  public GoldStatus(int balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("This balance value is illegal(negative)!");
    }

    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public StringBuilder getGoldStatus() {
    return new StringBuilder("Gold status : " + getBalance() + "\n");
  }

  public void withdraw(int amount) {

    if (amount < 0) {
      throw new IllegalArgumentException("This withdraw amount is illegal(negative)!");
    }

    if (balance < amount) {
      throw new IllegalArgumentException("Gold needed is not available!");
    }

    balance -= amount;
  }

  public void deposit(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("This deposit value is illegal(negative)!");
    }

    balance += amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoldStatus that = (GoldStatus) o;
    return balance == that.balance;
  }

}
