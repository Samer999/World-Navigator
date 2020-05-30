package Map.RoomObjects;

import java.io.Serializable;

public abstract class Closeable implements Serializable {

    private boolean isOpen;

    public boolean isOpen(){
        return isOpen;
    }

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }
}
