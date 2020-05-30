package Controllers.Commands.GameControllerCommands;

import Controllers.GameModeControls.Mode;

public class QuitMapCommand extends GameControllerCommand{


    public QuitMapCommand(Mode mode) {
        super(mode);
    }

    @Override
    public void execute() {
        getMode().quit();
    }

    @Override
    public String name() {
        return "Quit This Map";
    }
}
