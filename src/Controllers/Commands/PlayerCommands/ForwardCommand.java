package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class ForwardCommand extends PlayerCommand {


  public ForwardCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    getPlayer().forward();
  }

  @Override
  public String name() {
    return "Go Forward";
  }
}
