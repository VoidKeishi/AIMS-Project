package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		//Create new DVD object and add to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		// Add DVDs to the cart
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		// Testing new printCArt() method
		cart.printCart();
		// Testing new searchById() method
		cart.search(1); // Return "The Lion King"
		cart.search(4); // Return "The disc is not in the cart"
		// Testing new searchByTitle() method
		cart.search("Star Wars"); // Return "Star Wars"
		cart.search("Cinderella"); // Return "The disc is not in the cart"
	}

}
