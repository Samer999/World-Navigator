package Controllers.Commands.PlayerCommands;

import PlayerInfo.Player;

public class ItemsOfFacedTraderCommand extends PlayerCommand {


  public ItemsOfFacedTraderCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    System.out.println(getPlayer().itemsOfFacedTrader());
  }

  @Override
  public String name() {
    return "Items Of Faced Trader";
  }
}
