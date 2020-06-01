package Controllers.Commands.PlayerCommands;

import Items.Item;
import Map.RoomObjects.RoomObject;
import PlayerInfo.Player;
import PlayerInfo.Trader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SellCommand extends PlayerCommand {


  public SellCommand(Player player) {
    super(player);
  }


  @Override
  public void execute() {

    RoomObject trader0 = getPlayer().facingRoomObject();

    if (!(trader0 instanceof Trader)) {
      System.out.println("You are not facing a trader or a seller! selling is canceled...");
      return;
    }

    Trader trader = (Trader) trader0;

    int index = 0;

    Scanner scanner = new Scanner(System.in);

    Item item = null;

    System.out.println("This is your items, pick item to sell by it's index");
    System.out.println(getPlayer().getItemStatus());
    System.out.print("Enter index : ");

    try {

      index = scanner.nextInt();

      if (!getPlayer().isValidItemIndex(index)) {
        throw new InputMismatchException();
      }

      item = getPlayer().getItemByIndex(index);

    } catch (InputMismatchException e) {
      System.out.println("This is not a valid index! selling is canceled...");
      return;
    }

    trader.buyItem(getPlayer(), item);

  }

  @Override
  public String name() {
    return "Sell Item";
  }
}
