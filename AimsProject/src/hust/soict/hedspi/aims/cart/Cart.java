package hust.soict.hedspi.aims.cart;
import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    // Attributes
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    //Methods
    public void addMedia(Media media) throws LimitExceededException, IllegalArgumentException{
		if (itemsOrdered.size() == 0) {
			itemsOrdered.add(media);
			System.out.println("This media has been added");
		}
		else if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			int check = 0;
			for (int i = 0; i < itemsOrdered.size(); i++ ) {
				if (itemsOrdered.get(i).equals(media)) {
					check += 1;
				}
			}
			if (check == 0) {
				itemsOrdered.add(media);
				System.out.println("This media has been added");
			}
			else {
				throw new IllegalArgumentException("ERROR: This media is already in the cart");
			}

		}
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}

    public void removeMedia(Media media) throws IllegalArgumentException{
		int index = -1;
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).equals(media)) {
				index = i;
			}
		}
		if (index == -1) {
			throw new IllegalArgumentException("This media is not in the cart");
		}
		else {
			itemsOrdered.remove(index);
			System.out.println("This media has been removed");
		}
	}

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public String printCart() {
    	String info = "";
        if (itemsOrdered.isEmpty()) {
            info = "The cart is empty";
        }
        else {
            info += ("***********************CART***********************\n");
            info += "Ordered Items:\n";
            for (Media item : itemsOrdered) {
                info += (item.toString()) + "\n";
            }
            info = info + "Total cost: " + totalCost();
            info += "***************************************************\n";
        }
        return info;
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
		return itemsOrdered;
	}
	public void playMedia(String title) {
		Media media = null ;
		for (int i = 0; i < itemsOrdered.size(); i ++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				media = itemsOrdered.get(i);
				break;
			}
		}
		if (media instanceof Playable) {
			try {
				((Playable) media).play();
			}catch (PlayerException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}