package Items;

public class FlashLight extends Light {

  public FlashLight(int price) {
    super(price);
  }

  @Override
  public String toString() {
    return "Flash Light{" + "price=" + getPrice() + "}";
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
