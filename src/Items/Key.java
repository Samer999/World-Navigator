package Items;

import java.util.Objects;

public class Key extends Item {

  private String name;

  public Key(int price, String name) {
    super(price);
    if (name == null) {
      throw new NullPointerException("Key name is null!");
    }

    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equalToUse(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof Key)) {
      return false;
    }

    return ((Key) o).name.equals(name);
  }

  @Override
  public String toString() {
    return "Key{" + "name=" + name + "\tprice=" + getPrice() + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Key key = (Key) o;
    return name.equals(key.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name);
  }
}
