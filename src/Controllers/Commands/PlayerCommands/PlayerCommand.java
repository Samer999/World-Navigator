package Controllers.Commands.PlayerCommands;

import Controllers.Commands.Command;
import PlayerInfo.Player;

public abstract class PlayerCommand implements Command {

  private Player player;

  public PlayerCommand(Player player) {
    if (player == null) {
      throw new NullPointerException("player value is null!");
    }

    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }
}
