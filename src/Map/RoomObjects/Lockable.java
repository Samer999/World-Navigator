package Map.RoomObjects;

import Items.Key;

/**
 * Lockable could be any room object that could be locked, every lockable is closable but not every
 * closable is a lockable
 */
public abstract class Lockable extends Closeable {

  private Key lockKey;
  private boolean isUnlocked;

  public Lockable(Key lockKey) {
    if (lockKey == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    this.lockKey = lockKey;
  }

  public Lockable() {
    // default constructor
    isUnlocked = true; // because there is no lock
  }

  public boolean isUnlocked() {
    return isUnlocked;
  }

  public String getKeyName() {

    if (lockKey == null) {
      return ""; // there is no lock key in the first place, so we return empty name string
    }

    return lockKey.getName();
  }

  public void useKey(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("key value is null!");
    }

    if (lockKey == null) {
      System.out.println("you cant use key here, no lock is here");
      return;
    }

    close(); // make sure to close the door if it was opened, so the key get tested

    if (lockKey.equalToUse(key)) {
      if (isUnlocked) {
        lock();
      } else {
        unlock();
      }
    } else {
      System.out.println("This is not a usable key for this Lockable!");
    }
  }

  @Override
  public void open() {
    if (!isUnlocked()) {
      System.out.println(lockKey.getName() + " key required to unlock");
    } else {
      super.open();
    }
  }

  private void unlock() {
    isUnlocked = true;
  }

  private void lock() {
    isUnlocked = false;
  }
}
