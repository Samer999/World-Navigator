package Items;

import java.util.Objects;

public abstract class Light extends Item {

  private boolean lightOn;

  public Light(int price) {
    super(price);
  }

  public void toggle() {
    lightOn = !lightOn;
  }

  public boolean isLightOn() {
    return lightOn;
  }

  @Override
  public boolean equalToUse(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof Light)) {
      return false;
    }

    return true;
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
    Light light = (Light) o;
    return lightOn == light.lightOn;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), lightOn);
  }
}
