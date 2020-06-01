package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class DropHeldLightCommand extends PlayerCommand {


  public DropHeldLightCommand(Player player) {
    super(player);
  }


  @Override
  public void execute() {
    getPlayer().dropHeldLight();
  }

  @Override
  public String name() {
    return "Drop held light back to inventory";
  }
}
