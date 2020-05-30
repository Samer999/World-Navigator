package Controllers.Commands.GameControllerCommands;

import Controllers.Commands.Command;
import Controllers.GameModeControls.Mode;

public abstract class GameControllerCommand implements Command {

    Mode mode;


    public GameControllerCommand(Mode mode) {

        if (mode == null)
            throw new IllegalArgumentException("game controller value is null!");

        this.mode = mode;
    }

    public Mode getMode(){

        return mode;

    }

}
