package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class PlayerStatusCommand extends PlayerCommand {


  public PlayerStatusCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    System.out.println(getPlayer().getStatus());
  }

  @Override
  public String name() {
    return "Player status";
  }
}
