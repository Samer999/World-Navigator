package Controllers.GameModeControls;

import Controllers.Commands.Command;
import Controllers.Commands.GameControllerCommands.QuitMapCommand;
import Controllers.Commands.GameControllerCommands.RestartMapCommand;
import Map.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Mode {

  protected Map map;
  private ArrayList<Command> commands;
  private boolean isFinished;
  private String serializedMap; // store original map

  public Mode() {
    commands = new ArrayList();
  }

  public void setMap(Map map) {
    if (map == null) {
      throw new IllegalArgumentException("map value is null!");
    }

    this.map = map;
    saveOriginalMap();
    restartMap();
    initialValuesToRestart();
  }

  /**
   * save/serialize the map object into (serializedMap : String) so we can get the original map back
   * after a restart
   */
  private void saveOriginalMap() {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutput out = null;
    try {
      out = new ObjectOutputStream(bos);
      out.writeObject(map);
    } catch (IOException e) {
      e.printStackTrace();
    }
    final byte[] byteArray = bos.toByteArray();
    serializedMap = Base64.getEncoder().encodeToString(byteArray);
  }

  /** restart the map to it's original state */
  public void restartMap() {
    final byte[] bytes = Base64.getDecoder().decode(serializedMap);

    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    ObjectInput in = null;
    try {
      in = new ObjectInputStream(bis);
      map = (Map) in.readObject();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public boolean isFinished() {
    return isFinished;
  }

  public void finish() {
    isFinished = true;
  }

  public void addCommand(Command command) {

    if (command == null) {
      throw new IllegalArgumentException("command value is null!");
    }

    commands.add(command);
  }

  public void showCommands() {
    System.out.println("Game controller commands : ");

    for (int i = 0; i < commands.size(); i++) {
      System.out.println(i + " : " + commands.get(i).name());
    }
  }

  public void pickCommand() {

    Scanner scanner = new Scanner(System.in);
    int index = 0;
    Command command = null;
    System.out.print("Enter index : ");

    try {

      index = Integer.parseInt(scanner.next());

      if (index < 0 || index >= commands.size()) {
        throw new InputMismatchException();
      }

      command = commands.get(index);

    } catch (InputMismatchException | NumberFormatException e) {
      System.out.println("Invalid command index!");
      return;
    }

    command.execute();
  }

  public final void restart() {
    System.out.println("starting...");
    restartMap();
    isFinished = false;
    commands.clear();
    initialValuesToRestart();
    addDefaultCommands();
    commands.add(new RestartMapCommand(this));
    commands.add(new QuitMapCommand(this));
  }

  public final void start() {
    restart();
    run();
  }

  public abstract void run();

  public abstract void initialValuesToRestart();

  public abstract void quit();

  public abstract String getName();

  public abstract void addDefaultCommands();
}
