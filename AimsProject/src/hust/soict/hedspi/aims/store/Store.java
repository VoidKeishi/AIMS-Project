package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media is already in the list");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Add media successfully");
    }
    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("Media is not in the list");
            return;
        }
        itemsInStore.remove(media);
        System.out.println("Remove media successfully");
    }

}
