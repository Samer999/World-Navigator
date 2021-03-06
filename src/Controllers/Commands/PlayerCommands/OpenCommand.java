package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class OpenCommand extends PlayerCommand {

  public OpenCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    getPlayer().open();
  }

  @Override
  public String name() {
    return "Open";
  }
}
