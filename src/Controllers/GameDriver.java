package Controllers;

import Controllers.GameModeControls.Mode;
import Map.Map;
import Map.MapLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GameDriver is the main entity in this game It controls the different maps and game modes that it
 * has to offer
 */
public class GameDriver {

  private static GameDriver gameDriver = new GameDriver();
  private ArrayList<MapLoader> maps;
  private ArrayList<Mode> modes;

  private GameDriver() {
    maps = new ArrayList<MapLoader>();
    modes = new ArrayList<>();
  }

  public static GameDriver getInstance() {
    return gameDriver;
  }

  public void start() {
    findMaps();
    System.out.println("*** World Navigator ***");
    Scanner scanner = new Scanner(System.in);
    int whatToDoNext = 0;

    while (true) {
      System.out.print(
          "What do you want next?\n"
              + "0 : Start new game\n"
              + "1 : Exit World Navigator\n"
              + "Enter index : ");

      try {
        whatToDoNext = Integer.parseInt(scanner.next());
        if (whatToDoNext < 0 || whatToDoNext > 1) {
          throw new InputMismatchException();
        }

      } catch (InputMismatchException | NumberFormatException e) {
        System.out.println("invalid input!");
        continue;
      }

      if (whatToDoNext == 0) {
        startNewGame();
      } else {
        System.out.println("Exiting World Navigator...");
        return;
      }
    }
  }

  public void addGameMode(Mode mode) {
    if (mode == null) {
      throw new IllegalArgumentException("game controller value is null!");
    }

    modes.add(mode);
  }

  private void startNewGame() {

    Map map;
    Mode mode;

    if (maps.size() == 0) {
      System.out.println("Can't start a game, no map is available!");
      return;
    }

    if (modes.size() == 0) {
      System.out.println("Can't start a game, no Game modes are registered!");
      return;
    }
    System.out.println("which map do you want?");
    showPossibleMaps();
    map = pickMap();
    System.out.println("which game mode do you want?");
    showGameModes();
    mode = pickMode();
    mode.setMap(map);
    mode.start();
  }

  private void findMaps() {
    File file = new File("resources/maps");
    for (File fileEntry : file.listFiles()) {
      if (fileEntry.isDirectory()) {
        continue;
      }
      maps.add(new MapLoader(fileEntry));
    }
  }

  private void showPossibleMaps() {

    for (int i = 0; i < maps.size(); i++) {
      System.out.println(i + " : " + maps.get(i).getName());
    }
  }

  private Map getMap(int index) {
    if (index < 0 || index >= maps.size()) {
      throw new IndexOutOfBoundsException("This is not a valid index!");
    }

    return maps.get(index).getMap();
  }

  private Map pickMap() {

    Scanner scanner = new Scanner(System.in);
    int index = 0;
    Map map;

    while (true) {
      System.out.print("Enter map index : ");

      try {
        index = Integer.parseInt(scanner.next());
        map = getMap(index);
      } catch (NumberFormatException | IndexOutOfBoundsException e) {
        System.out.println("Not a valid index!");
        continue;
      }

      return map;
    }
  }

  private void showGameModes() {
    for (int i = 0; i < modes.size(); i++) {
      System.out.println(i + " : " + modes.get(i).getName());
    }
  }

  private Mode getMode(int index) {
    if (index < 0 || index > modes.size()) {
      throw new IndexOutOfBoundsException("index value is invalid!");
    }

    return modes.get(index);
  }

  private Mode pickMode() {
    Scanner scanner = new Scanner(System.in);
    int index = 0;
    Mode mode;

    while (true) {
      System.out.print("Enter game mode index : ");

      try {
        index = Integer.parseInt(scanner.next());
        mode = getMode(index);

      } catch (NumberFormatException | IndexOutOfBoundsException e) {
        System.out.println("Not a valid index!");
        continue;
      }

      return mode;
    }
  }
}
