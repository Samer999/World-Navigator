package Map.RoomObjects;

import java.io.Serializable;

/**
 * Closeable could be any room object that could be closed, it's different from Lockable, Some room
 * objects could be closed even without a lock, just by handle or something
 */
public abstract class Closeable implements Serializable {

  private boolean isOpen;

  public boolean isOpen() {
    return isOpen;
  }

  public void open() {
    isOpen = true;
  }

  public void close() {
    isOpen = false;
  }
}
