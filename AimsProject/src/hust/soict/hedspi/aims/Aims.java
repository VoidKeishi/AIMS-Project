package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
        public static void main(String[] args) {
                //Create a new cart
                Cart anOrder = new Cart();

                //Create new DVD object and add to the cart
                DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
                anOrder.addMedia(dvd1);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
                anOrder.addMedia(dvd2);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
                anOrder.addMedia(dvd3);
                
                // Print number, title and cost of DVDs in the cart
                anOrder.printCart();

                // Remove a DVD from the cart - Section 13
                anOrder.removeMedia(dvd3);
                
                // Print number, title and cost of DVDs in the cart after removing
                anOrder.printCart();

        }
}
