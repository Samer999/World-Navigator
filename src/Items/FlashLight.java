package Items;

public class FlashLight extends Light {

  public FlashLight(int price) {
    super(price);
  }


  @Override
  public String toString() {
    return "Flash Light{" + "price=" + getPrice() + "}";
  }


}
