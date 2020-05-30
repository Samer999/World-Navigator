package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class BackwardCommand extends PlayerCommand {

    public BackwardCommand(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        getPlayer().backward();
    }

    @Override
    public String name() {
        return "Go Backward";
    }
}
