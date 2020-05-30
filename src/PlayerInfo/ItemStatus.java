/*
* notes:
* get item by index
* boolean is validIndex(int index)?
* */

package PlayerInfo;



import Items.Item;
import Items.Key;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemStatus implements Serializable {

    private ArrayList<Item> itemList;

    public ItemStatus(){
        itemList = new ArrayList();
    }

    public void addItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item value is null");

        itemList.add(item);
    }

    public void removeItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item value is null");

        itemList.remove(item);
    }

    public boolean isValidIndex(int index) {
        if (index < 0 || index >= itemList.size())
            return false;

        return true;
    }

    public int numberOfItems(){
        return itemList.size();
    }

    public Key getKeyNamed(String keyName) {
        if (keyName == null)
            throw new IllegalArgumentException("key name string is null!");

        for (Item item : itemList) {
            if (item instanceof Key)
                if (((Key) item).getName() == keyName)
                    return (Key)item;
        }

        return null;
    }

    public Item getItemByIndex(int index) {
        if (isValidIndex(index) == false)
            throw new IndexOutOfBoundsException("This is not a valid index!");
        return itemList.get(index);
    }


    public boolean contains(Item item) {
        if (item == null)
            throw new IllegalArgumentException("item value is null!");

        return itemList.contains(item);
    }



    public StringBuilder getItemsStatus() {

        StringBuilder status = new StringBuilder("Item status : \n");

        for (int i = 0; i < itemList.size(); i++) {
            status.append("\t" + (i) + " : " + itemList.get(i) + "\n");
        }

        return status;
    }

}
