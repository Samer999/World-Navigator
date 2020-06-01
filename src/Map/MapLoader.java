package Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MapLoader {

  private Map map;
  private File file;

  public MapLoader(File file) {
    if (file == null) {
      throw new IllegalArgumentException("file value is null!");
    }
    this.file = file;
  }

  public Map getMap() {
    load();
    return map;
  }

  public String getName() {
    return file.getName();
  }

  private void load() {//proxy pattern

    if (map != null) {
      return;
    }

    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      map = (Map) objectInputStream.readObject();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }


}
