package Tests.RoomObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Items.Key;
import Map.RoomObjects.Chest;
import Map.RoomObjects.Door;
import Map.RoomObjects.Lockable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockableTest {

  Lockable door;
  Lockable chest;

  @BeforeEach
  void setUp() {
    door = new Door();
    chest = new Chest(new Key(0, "Samer"));
  }

  @Test
  void isUnlocked1() {
    assertTrue(door.isUnlocked());
    assertFalse(chest.isUnlocked());
  }

  @Test
  void isUnlocked2() {
    chest.useKey(new Key(0, "Samer"));
    assertTrue(chest.isUnlocked());
  }

  @Test
  void getKeyName() {
    assertEquals(door.getKeyName(), "");
    assertEquals(chest.getKeyName(), "Samer");
  }

  @Test
  void useKey() {
    assertFalse(chest.isUnlocked());
    chest.useKey(new Key(0, "Samer"));
    assertTrue(chest.isUnlocked());
  }

  @Test
  void open1() {

    assertFalse(chest.isUnlocked());
    assertFalse(chest.isOpen());
    chest.useKey(new Key(10, "Samer"));
    chest.open();
    assertTrue(chest.isOpen());
  }

  @Test
  void open2() {

    assertTrue(door.isUnlocked());
    assertFalse(door.isOpen());
    door.open();
    assertTrue(door.isOpen());
  }
}