package Controllers.Commands.GameControllerCommands;

import Controllers.Commands.Command;
import Controllers.GameModeControls.Mode;

public abstract class GameModeCommand implements Command {

  Mode mode;

  public GameModeCommand(Mode mode) {

    if (mode == null) {
      throw new IllegalArgumentException("game controller value is null!");
    }

    this.mode = mode;
  }

  public Mode getMode() {

    return mode;
  }
}
