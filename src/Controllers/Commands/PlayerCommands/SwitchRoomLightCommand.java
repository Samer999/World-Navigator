package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class SwitchRoomLightCommand extends PlayerCommand  {


    public SwitchRoomLightCommand(Player player) {
        super(player);
    }


    @Override
    public void execute() {
        getPlayer().switchRoomLight();
    }

    @Override
    public String name() {
        return "Switch Room Light";
    }
}
