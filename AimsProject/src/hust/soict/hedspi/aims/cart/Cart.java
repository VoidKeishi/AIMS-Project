package hust.soict.hedspi.aims.cart;
import java.util.Collections;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    // Attributes
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    //Methods
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Media is already in the list");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Add media successfully");
    }
    
    public void addMedia(Media[] mediaArray) {
        for (Media media : mediaArray) {
            if (itemsOrdered.contains(media)) {
                System.out.println("Media " + media + " is already in the list");
            } else {
                itemsOrdered.add(media);
                System.out.println("Added media " + media + " successfully");
            }
        }
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            System.out.println("Media is not in the list");
            return;
        }
        itemsOrdered.remove(media);
        System.out.println("Remove media successfully");
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void printCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
            return;
        }
        else {
            System.out.println("***********************CART***********************");
            System.out.println("Ordered Items:");
            for (Media item : itemsOrdered) {
                System.out.println(item.toString());
            }
            System.out.printf("Total cost: %-5.2f$\n", totalCost());
            System.out.println("***************************************************");
        }
    }
    
    public void search(int id){
        // Check if the DVD with the id is in the cart
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item instanceof DigitalVideoDisc && ((DigitalVideoDisc) item).isMatch(id)) {
                System.out.println(item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart");
        }
    }

    public void search(String title){
        // Check if the DVD with the title is in the cart
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item instanceof DigitalVideoDisc && ((DigitalVideoDisc) item).isMatch(title)) {
                System.out.println(item.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart");
        }
    }

    // Section 18
    public void filterById(int id) {
    	int filtered = 0;
    	for(Media item: itemsOrdered) {
    		if (item.isMatch(id)) {
    			System.out.println("Filter result: \n");
    			System.out.println(item.toString());
    			filtered = 1;
    		}
    	}
    	if (filtered == 0) {
    		System.out.println("No such media in cart!");
    	}
    }
    
    public void filterByTitle(String title) {
    	int filtered = 0;
    	for(Media item: itemsOrdered) {
    		if (item.isMatch(title)) {
    			System.out.println("Filter result: \n");
    			System.out.println(item.toString());
    			filtered = 1;
    		}
    	}
    	if (filtered == 0) {
    		System.out.println("No such media in cart!");
    	}
    }
    
    public void sortMediaByTitle() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    public void sortMediaByCost() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void emptyCart() {
    	itemsOrdered.clear();
    }
    
    // Return the media instead of just checking
    public Media searchMediaByTitle(String title) {
    	for (Media item: itemsOrdered) {
    		if (item.isMatch(title)) return item;
    	}
    	return null;
    }
    public ObservableList<Media> getItemsOrdered() {
		return FXCollections.observableArrayList(itemsOrdered);
	}
}