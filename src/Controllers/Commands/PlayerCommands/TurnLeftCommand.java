package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class TurnLeftCommand extends PlayerCommand {

  public TurnLeftCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    getPlayer().turnLeft();
  }

  @Override
  public String name() {
    return "Turn Left";
  }
}
