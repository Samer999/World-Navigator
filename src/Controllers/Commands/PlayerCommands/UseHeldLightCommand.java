package Controllers.Commands.PlayerCommands;

import Controllers.Commands.Command;
import PlayerInfo.Player;

public class UseHeldLightCommand extends PlayerCommand {


    public UseHeldLightCommand(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        getPlayer().useHeldLight();
    }

    @Override
    public String name() {
        return "Use Held Light";
    }
}
