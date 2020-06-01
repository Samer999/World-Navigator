import Controllers.GameDriver;
import Controllers.GameModeControls.OnePlayerMode;

public class Main {

  public static void main(String[] args) {

    GameDriver game = GameDriver.getInstance();

    OnePlayerMode gameControllerOnePlayer = new OnePlayerMode();

    game.addGameMode(gameControllerOnePlayer);

    game.start();


  }
}
