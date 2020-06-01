package Map.RoomObjects;

import PlayerInfo.Player;

public interface LootHidder {

  Loot getLoot();

  void loot(Player player);
}
