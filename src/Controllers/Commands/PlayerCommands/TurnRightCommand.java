package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class TurnRightCommand extends PlayerCommand {


  public TurnRightCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    getPlayer().turnRight();
  }

  @Override
  public String name() {
    return "Turn right";
  }
}
