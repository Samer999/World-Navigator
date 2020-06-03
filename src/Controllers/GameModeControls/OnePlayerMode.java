package Controllers.GameModeControls;

import Controllers.Commands.PlayerCommands.BackwardCommand;
import Controllers.Commands.PlayerCommands.CheckCommand;
import Controllers.Commands.PlayerCommands.DropHeldLightCommand;
import Controllers.Commands.PlayerCommands.ForwardCommand;
import Controllers.Commands.PlayerCommands.HoldLightCommand;
import Controllers.Commands.PlayerCommands.LookCommand;
import Controllers.Commands.PlayerCommands.OpenCommand;
import Controllers.Commands.PlayerCommands.PlayerStatusCommand;
import Controllers.Commands.PlayerCommands.SwitchRoomLightCommand;
import Controllers.Commands.PlayerCommands.TradeCommand;
import Controllers.Commands.PlayerCommands.TurnLeftCommand;
import Controllers.Commands.PlayerCommands.TurnRightCommand;
import Controllers.Commands.PlayerCommands.UseHeldLightCommand;
import Controllers.Commands.PlayerCommands.UseKeyCommand;
import Controllers.GameTimer.GameTimer;
import PlayerInfo.Player;

public class OnePlayerMode extends Mode {

  private Player player;
  private GameTimer gameTimer;

  @Override
  public void initialValuesToRestart() {
    player = new Player();
    player.setCurrentRoom(map.getStartRoom());
    player.setDirection(map.getPlayerFacingDirection());
    player.giveGold(map.getInitialGold());

    if (gameTimer != null) {
      gameTimer.stop();
    }

    gameTimer = new GameTimer(map.getTimeToFinish());
  }

  @Override
  public void quit() {
    finish();
  }

  @Override
  public String getName() {
    return "One player with a timer";
  }

  public void addDefaultCommands() {
    addCommand(new ForwardCommand(player));
    addCommand((new BackwardCommand(player)));
    addCommand(new TurnLeftCommand(player));
    addCommand(new TurnRightCommand(player));
    addCommand(new PlayerStatusCommand(player));
    addCommand(new LookCommand(player));
    addCommand(new CheckCommand(player));
    addCommand(new OpenCommand(player));
    addCommand(new HoldLightCommand(player));
    addCommand(new DropHeldLightCommand(player));
    addCommand(new UseHeldLightCommand(player));
    addCommand((new SwitchRoomLightCommand(player)));
    addCommand(new TradeCommand(player));
    addCommand(new UseKeyCommand(player));
  }

  @Override
  public void run() {
    gameTimer.start();
    while (true) {

      if (isFinished() || player.getCurrentRoom() == map.getGoalRoom() || gameTimer.isTimeOut()) {

        if (gameTimer.isTimeOut()) {
          System.out.println("Timeout, you lost!");
        } else if (player.getCurrentRoom() == map.getGoalRoom()) {
          System.out.println("You have won!");
        } else {
          System.out.println("You have lost!");
        }
        break;
      }

      showCommands();
      pickCommand();
    }
    gameTimer.stop();
  }
}
