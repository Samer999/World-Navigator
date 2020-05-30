package Tests.RoomObjects;

import Items.Key;
import Map.RoomObjects.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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