package Controllers.Commands.PlayerCommands;

import Items.Item;
import Items.Key;
import PlayerInfo.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseKeyCommand extends PlayerCommand {

  public UseKeyCommand(Player player) {
    super(player);
  }

  @Override
  public void execute() {

    int index = 0;

    Scanner scanner = new Scanner(System.in);

    Item item = null;

    System.out.println(getPlayer().getItemStatus());
    System.out.print("Enter key index : ");

    try {

      index = scanner.nextInt();

      if (!getPlayer().isValidItemIndex(index)) {
        throw new InputMismatchException();
      }

      item = getPlayer().getItemByIndex(index);

      if (!(item instanceof Key)) {
        throw new InputMismatchException();
      }

    } catch (InputMismatchException e) {
      System.out.println("This is not a valid key index!");
      return;
    }

    getPlayer().useKey((Key) item);
  }

  @Override
  public String name() {
    return "Use Key";
  }
}
