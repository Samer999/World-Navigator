package Controllers.Commands.PlayerCommands;

import Items.Item;
import Items.Light;
import PlayerInfo.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HoldLightCommand extends PlayerCommand {


  public HoldLightCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {

    int index = 0;

    Scanner scanner = new Scanner(System.in);

    Item light = null;

    if (getPlayer().isHoldingLight()) {
      System.out.println(
          "You are already holding a light, if you pick a light now, it would be replaced");
    }

    System.out.println(getPlayer().getItemStatus());
    System.out.print("Enter light index : ");

    try {

      index = scanner.nextInt();
      if (!getPlayer().isValidItemIndex(index)) {
        throw new InputMismatchException();
      }

      light = getPlayer().getItemByIndex(index);

      if (!(light instanceof Light)) {
        throw new IllegalArgumentException();
      }

    } catch (InputMismatchException e) {
      System.out.println("This is not a valid index! holding a light is canceled...");
      return;
    } catch (IllegalArgumentException e) {
      System.out.println("This is not a light! holding a light is canceled...");
      return;
    }

    getPlayer().takeAwayItem(light);
    getPlayer().holdLight((Light) light);

  }

  @Override
  public String name() {
    return "Hold light from inventory";
  }
}
