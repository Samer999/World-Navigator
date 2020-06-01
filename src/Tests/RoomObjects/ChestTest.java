package Tests.RoomObjects;

import static org.junit.Assert.assertEquals;

import Items.FlashLight;
import Items.Key;
import Map.RoomObjects.Chest;
import Map.RoomObjects.FullLoot;
import PlayerInfo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChestTest {

  Player player;
  Chest chest;

  @BeforeEach
  void setUp() {
    player = new Player();
    player.giveGold(100);

    ///////////Player items//////////
    player.giveItem(new Key(20, "Samer"));
    player.giveItem(new FlashLight(5));
    ////////////////////////////////

    /////////Create full loot///////
    FullLoot loot = new FullLoot();
    loot.addItem(new Key(200, "Amer"));
    loot.addItem(new FlashLight(400));
    loot.addGold(200);
    ///////////////////////////////

    ////////Add loot to chest///////
    chest = new Chest();
    chest.setLoot(loot);
    ///////////////////////////////

  }


  @Test
  void loot() {

    Player player2 = new Player();
    player2.giveGold(300);
    player2.giveItem(new Key(20, "Samer"));
    player2.giveItem(new FlashLight(5));
    player2.giveItem(new FlashLight(400));
    player2.giveItem(new Key(200, "Amer"));

    chest.loot(player);

    assertEquals(player.getStatus().toString(), player2.getStatus().toString());

    System.out.println();

  }
}