package Controllers.Commands.GameControllerCommands;

import Controllers.GameModeControls.Mode;

public class RestartMapCommand extends GameModeCommand {

  public RestartMapCommand(Mode mode) {
    super(mode);
  }

  @Override
  public void execute() {
    getMode().restart();
  }

  @Override
  public String name() {
    return "Restart Map";
  }
}
