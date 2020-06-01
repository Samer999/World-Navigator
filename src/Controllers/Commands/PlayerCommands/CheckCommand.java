package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class CheckCommand extends PlayerCommand {


  public CheckCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    getPlayer().check();
  }

  @Override
  public String name() {
    return "Check";
  }
}
