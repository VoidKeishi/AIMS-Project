package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {

    // Attributes
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
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

    // Print the list of ordered items of a cart - Lab 3 Section 4
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

}