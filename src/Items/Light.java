package Items;


public abstract class Light extends Item {

    private boolean lightOn;

    public Light(int price) {
        super(price);
    }

    public void toggle(){
        lightOn = !lightOn;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    @Override
    public boolean equalToUse(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Light))
            return false;

        return true;
    }




}
