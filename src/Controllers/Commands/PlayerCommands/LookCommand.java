package Controllers.Commands.PlayerCommands;

import Controllers.Commands.Command;
import PlayerInfo.Player;

public class LookCommand extends PlayerCommand  {


    public LookCommand(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        getPlayer().look();
    }

    @Override
    public String name(){
        return "Look";
    }
}
