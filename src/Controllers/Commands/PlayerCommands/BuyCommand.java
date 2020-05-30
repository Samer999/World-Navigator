package Controllers.Commands.PlayerCommands;

import Items.Item;
import Map.RoomObjects.RoomObject;
import PlayerInfo.Player;
import PlayerInfo.Trader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyCommand extends PlayerCommand {



    public BuyCommand(Player player) {
        super(player);
    }

    @Override
    public void execute() {
        RoomObject trader0 = getPlayer().facingRoomObject();

        if (!(trader0 instanceof Trader)) {
            System.out.println("You are not facing a trader! buying is canceled...");
            return;
        }


        Trader trader = (Trader) trader0;

        int index = 0;

        Scanner scanner = new Scanner(System.in);

        Item item = null;

        System.out.println(trader.getItemStatus());
        System.out.print("Enter index : ");

        try {

            index = new Scanner(System.in).nextInt();

            if (!trader.isValidItemIndex(index))
                throw new InputMismatchException();

            item = trader.getItemByIndex(index);

        } catch (InputMismatchException e) {

            System.out.println("This is not a valid index! buying is canceled...");

            return;

        }

        getPlayer().buyItem(trader, item);

    }

    @Override
    public String name() {
        return "Buy Item";
    }
}
