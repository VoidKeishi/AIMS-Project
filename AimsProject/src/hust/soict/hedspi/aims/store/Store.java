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
    
    public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	// Section 18
    public Media findMediaByTitle(String title) {
		for (Media m: itemsInStore) {
			if (m.isMatch(title)) {
				System.out.println("Media founded!\n" + m.toString());
				return m;
			}
		}
		System.out.println("No such media in store!");
		return null;
	}
	
	public void showStore() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(i+1 + ". " + itemsInStore.get(i).toString() );
		}
	}
}
