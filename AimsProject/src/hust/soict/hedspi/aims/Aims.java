package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.menu.Menu;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class Aims {
	
	public static Media getMediaInfo() {
		Scanner scanner = new Scanner(System.in);
		int mediaType;
		int id;
		String title;
		String category;
		float cost;
		String author;
		List<String> authors = new ArrayList<String>();
		int length;
		String director;
		String artist;
		String trackTitle;
		int trackLength;
		
		System.out.println("Choose type of media:");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DVD");
		System.out.println("3. CD");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2-3");
		
		do {
			mediaType = scanner.nextInt();
			scanner.nextLine();
			if (mediaType < 1 || mediaType > 3) System.out.println("Please provide an option between 1 to 3!");
		} while (mediaType < 1 || mediaType > 3);
		System.out.println("Enter the media id: ");
		id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the media title: ");
		title = scanner.nextLine();
		System.out.println("Enter the media category: ");
		category = scanner.nextLine();
		System.out.println("Enter the media cost: ");
		cost = scanner.nextFloat();
		scanner.nextLine();
		
		if (mediaType == 1) {
			while(true) {
				System.out.println("Enter the author name (Press q to stop entering): ");
				author = scanner.nextLine();
				if (!author.equals("q")) authors.add(author);
				else break;
			}
			Book book = new Book(id, title, category, cost);
			for (String a: authors) {
				book.addAuthor(a);
			}
			scanner.close();
			return book;
		} else if (mediaType == 2) {
			System.out.println("Enter the media length: ");
			length = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the media director: ");
			director = scanner.nextLine();
			DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
			scanner.close();
			return dvd;
		} else {
			System.out.println("Enter the media director: ");
			director = scanner.nextLine();
			System.out.println("Enter the media artist: ");
			artist = scanner.nextLine();
			CompactDisc cd = new CompactDisc(id, title, artist, category, director, cost);
			while(true) {
				System.out.println("Enter the track title (Enter q to quit): ");
				trackTitle = scanner.nextLine();
				System.out.println("Enter the track length: ");
				trackLength = scanner.nextInt();
				scanner.nextLine();
				if (!trackTitle.equals("q")) cd.addTrack(new Track(trackTitle, trackLength));
				break;
			}
			scanner.close();
			return cd;
		}
	}

    public static void main(String[] args) {
       Store store = new Store();
       Cart cart = new Cart();
       while(true) {
    	   Menu.showMenu();
    	   Scanner scanner = new Scanner(System.in);
    	   int option;
    	   do {
    		   option = scanner.nextInt();
    		   if (option > 3 || option < 0) System.out.println("Please provide a number between 0 - 3!");
    	   }while (option > 3 || option < 0);
    	   
    	   switch(option) {
    	   		case 1:
    	   			while(option != 0) {
    	   				Menu.storeMenu();
        	   			do {
        	     		   option = scanner.nextInt();
        	     		   scanner.nextLine();
        	     		   if (option > 4 || option < 0) System.out.println("Please provide a number between 0 - 4!");
        	   			}while (option > 4 || option < 0);
        	   			switch(option) {
        	   				case 1:
        	   					System.out.println("Enter the title of the media: ");
        	   					String title = scanner.nextLine();
        	   					Media founded = store.findMediaByTitle(title);
        	   					if (founded != null) {
        	   						if (founded instanceof Book) {
        	   							Menu.bookDetailsMenu();
        	   							do {
         	   		    	     		   option = scanner.nextInt();
         	   		    	     		   scanner.nextLine();
         	   		    	     		   if (option > 1 || option < 0) System.out.println("Please provide a number between 0 - 1!");
         	   		    	   			}while (option > 1 || option < 0);
         	   							if (option == 1) {
         	   								cart.addMedia(founded);
         	   							}
        	   						} else {
        	   							Menu.playableDetailsMenu();
        	   							do {
        	   		    	     		   option = scanner.nextInt();
        	   		    	     		   scanner.nextLine();
        	   		    	     		   if (option > 2 || option < 0) System.out.println("Please provide a number between 0 - 2!");
        	   		    	   			}while (option > 2 || option < 0);
        	   							if (option == 1) {
        	   								cart.addMedia(founded);
        	   							} else if (option == 2) {
        	   								if (founded instanceof DigitalVideoDisc) {
        	   									DigitalVideoDisc dvd = (DigitalVideoDisc) founded;
        	   									dvd.play();
        	   								} else {
        	   									CompactDisc cd = (CompactDisc) founded;
        	   									cd.play();
        	   								}
        	   							}
        	   						}
        	   					}
        	   					break;
        	   				case 2:
        	   					store.showStore();
        	   					System.out.println("Enter the title of the media you want to add to cart: ");
        	   					title = scanner.nextLine();
        	   					founded = store.findMediaByTitle(title);
        	   					if (founded != null) cart.addMedia(founded);
        	   					else System.out.println("Failed to add media to cart!");
        	   					break;
        	   				case 3:
        	   					store.showStore();
        	   					System.out.println("Enter the title of the media you want to play: ");
        	   					title = scanner.nextLine();
        	   					founded = store.findMediaByTitle(title);
        	   					if (founded != null) {
        	   						if (founded instanceof DigitalVideoDisc) {
	   									DigitalVideoDisc dvd = (DigitalVideoDisc) founded;
	   									dvd.play();
	   								} else if (founded instanceof CompactDisc) {
	   									CompactDisc cd = (CompactDisc) founded;
	   									cd.play();
	   								} else {
	   									System.out.println("Media book can't be play!");
	   								}
        	   					} else System.out.println("Failed to play media!");
        	   					break;
        	   				case 4:
        	   					cart.printCartListFormat();
        	   					Menu.cartMenu();
        	   					break;
        	   				case 0:
        	   					System.out.println("Going back....");
        	   					break;
        	   			}
    	   			}
    	   			break;
    	   		case 2:
    	   			Menu.updateStoreOptionMenu();
   					do {
     	     		   option = scanner.nextInt();
     	     		   scanner.nextLine();
     	     		   if (option > 2 || option < 0) System.out.println("Please provide a number between 0 - 2!");
   					}while (option > 2 || option < 0);
   					switch(option) {
   						case 1:
   							Media media = getMediaInfo();
   							store.addMedia(media);
   							break;
   						case 2:
   							System.out.println("Enter the media title you want to remove from store: ");
   							String title = scanner.nextLine();
   							Media founded = store.findMediaByTitle(title);
   							store.removeMedia(founded);
   							break;
   						case 0:
   							System.out.println("Canceling update store....");
   							break;
   					}
    	   			break;
    	   		case 3:
    	   			while(option != 0) {
    	   				cart.printCartListFormat();
        	   			Menu.cartMenu();
        	   			do {
          	     		   option = scanner.nextInt();
          	     		   scanner.nextLine();
          	     		   if (option > 5 || option < 0) System.out.println("Please provide a number between 0 - 5!");
        				} while (option > 5 || option < 0);
        	   			switch(option) {
        	   				case 1:
        	   					Menu.filterOptionMenu();
        	   					do {
     	          	     		   option = scanner.nextInt();
     	          	     		   scanner.nextLine();
     	          	     		   if (option > 2 || option < 1) System.out.println("Please provide a number between 1 - 2!");
	     	        			} while (option > 2 || option < 1);
	     	   					switch (option) {
	     	   						case 1:
	     	   							System.out.println("Enter media's id to filter: ");
	     	   							int id = scanner.nextInt();
	     	   							scanner.nextLine();
	     	   							cart.filterById(id);
	     	   							break;
	     	   						case 2:
		     	   						System.out.println("Enter media's id to filter: ");
	     	   							String title = scanner.nextLine();
	     	   							cart.filterByTitle(title);
	     	   							break;
	     	   						default:
	     	   							System.out.println("Going back...");
	     	   							break;
	     	   					}
        	   					break;
        	   				case 2:
        	   					Menu.sortOptionMenu();
        	   					do {
        	          	     		   option = scanner.nextInt();
        	          	     		   scanner.nextLine();
        	          	     		   if (option > 2 || option < 1) System.out.println("Please provide a number between 1 - 2!");
        	        			} while (option > 2 || option < 1);
        	   					switch (option) {
        	   						case 1:
        	   							cart.sortMediaByTitle();
        	   							break;
        	   						case 2:
        	   							cart.sortMediaByCost();
        	   							break;
        	   						default:
        	   							System.out.println("Going back...");
        	   							break;
        	   					}
        	   					break;
        	   				case 3:
        	   					System.out.println("Enter the title of the media you want to remove: ");
        	   					String title = scanner.nextLine();
        	   					Media founded = cart.searchMediaByTitle(title);
        	   					cart.removeMedia(founded);
        	   					break;
        	   				case 4:
        	   					cart.printCartListFormat();
        	   					System.out.println("Enter the title of the media you want to play: ");
        	   					title = scanner.nextLine();
        	   					founded = cart.searchMediaByTitle(title);
        	   					if (founded != null) {
        	   						if (founded instanceof DigitalVideoDisc) {
	   									DigitalVideoDisc dvd = (DigitalVideoDisc) founded;
	   									dvd.play();
	   								} else if (founded instanceof CompactDisc) {
	   									CompactDisc cd = (CompactDisc) founded;
	   									cd.play();
	   								} else {
	   									System.out.println("Media book can't be play!");
	   								}
        	   					} else System.out.println("Failed to play media!");
        	   					break;
        	   				case 5:
        	   					System.out.println("An order has been created!");
        	   					cart.emptyCart();
        	   					break;
        	   				case 0:
        	   					System.out.println("Going back....");
        	   					break;
        	   			}
    	   			}
    	   			break;
    	   		case 0:
    	   			scanner.close();
    	   			System.exit(0);
    	   }
       }
       
    }
}
