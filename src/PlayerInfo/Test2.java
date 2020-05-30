package PlayerInfo;


import Items.Key;
import Map.MapLoader;
import Map.RoomObjects.Seller;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {

        findMaps();


//        player.trade(seller);


    }

    static private void findMaps(){
        File file = new File("resources/maps");
        for (File fileEntry : file.listFiles()) {
            if (fileEntry.isDirectory())
                continue;
            System.out.println(fileEntry.getName());
        }
    }

}
