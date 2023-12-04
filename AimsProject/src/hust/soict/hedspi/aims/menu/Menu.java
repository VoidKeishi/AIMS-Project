package hust.soict.hedspi.aims.menu;
public class Menu{
	public static void mainMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void updateStoreOptionMenu() {
		System.out.println("Update Store Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Cancel");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void bookDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	public static void playableDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void sortOptionMenu() {
		System.out.println("Sort Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By cost");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");
	}
	
	public static void filterOptionMenu() {
		System.out.println("Fitler Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By id");
		System.out.println("2. By title");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");
	}

	public static void mediaTypeMenu() {
		System.out.println("Media Type: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DVD");
		System.out.println("3. CD");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2-3");
	}
}

