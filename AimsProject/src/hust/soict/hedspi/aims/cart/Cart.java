package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {

    // Attributes
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    //Methods
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Media is already in the list");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Add media successfully");
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
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
        System.out.printf("Total cost: %-5.2f$\n", totalCost());
        System.out.println("***************************************************");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (itemsOrdered.size() + dvdList.length <= MAX_NUMBER_ORDERED) {
            for (DigitalVideoDisc digitalVideoDisc : dvdList) {
                itemsOrdered.add(digitalVideoDisc);
            }
            System.out.println("The discs have been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (itemsOrdered.size() + 2 <= MAX_NUMBER_ORDERED) {
            itemsOrdered.add(dvd1);
            itemsOrdered.add(dvd2);
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
    
    public Media searchMediaByTitle(String title) {
    	for (Media item: itemsOrdered) {
    		if (item.isMatch(title)) return item;
    	}
    	return null;
    }
    
    public void printCartListFormat() {
    	if (itemsOrdered.size() == 0) {
    		System.out.println("No items in cart to display!");
    	} else {
    		System.out.println("The current cart: ");
    		for (int i = 0; i < itemsOrdered.size(); i++) {
    			System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
    		}
    		System.out.printf("Total cost: %.2f\n\n", totalCost());
    	}
    }
}