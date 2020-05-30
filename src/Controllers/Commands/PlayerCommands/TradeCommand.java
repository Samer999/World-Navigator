package Controllers.Commands.PlayerCommands;

import Controllers.Commands.Command;
import PlayerInfo.Player;
import PlayerInfo.Trader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TradeCommand extends PlayerCommand {

    private BuyCommand buyCommand;
    private SellCommand sellCommand;
    private ItemsOfFacedTraderCommand itemsOfFacedTraderCommand;


    public TradeCommand(Player player) {
        super(player);

        buyCommand = new BuyCommand(player);
        sellCommand = new SellCommand(player);
        itemsOfFacedTraderCommand = new ItemsOfFacedTraderCommand(player);
    }

    @Override
    public void execute() {

        if (!(getPlayer().facingRoomObject() instanceof Trader)) {
            System.out.println("You are not facing a trader!");
            return;
        }

        itemsOfFacedTraderCommand.execute();

        while(true) {
            int index = 0;

            Scanner scanner = new Scanner(System.in);

            System.out.print("What do you want to do next?\n" +
                    "0 : Buy\n" +
                    "1 : Sell\n" +
                    "2 : List the items of the trader you are facing\n" +
                    "3 : Stop trading\n" +
                    "Enter index : ");



            try {
                index = scanner.nextInt();

                if (index == 3) {
                    System.out.println("Stop trading...");
                    break;
                }

                if (index < 0 || index > 2)
                    throw new InputMismatchException();

            } catch (InputMismatchException e) {
                System.out.println("Invalid command index! canceling trading...");
                break;
            }

            if (index == 0)
                buyCommand.execute();
            else if (index == 1)
                sellCommand.execute();
            else
                itemsOfFacedTraderCommand.execute();
        }

    }

    @Override
    public String name() {
        return "Trade";
    }
}
