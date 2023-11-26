package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class TestToStringMedia{
	public static void main(String[] args){
		List<Media> items = new ArrayList<Media>();
		Book book1 = new Book(1, "Harry Potter", "Fantasy", 20f);
		book1.addAuthor("J.K.Rowling");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f);
		CompactDisc cd1 = new CompactDisc(123, "Thriller", "Micheal Jackson", "Pop", 25.65f, "Micheal Jackson");
		Track track1 = new Track("Wanna Be Startin' Somethin", 363);
        Track track2 = new Track("Baby Be Mine", 260);
        Track track3 = new Track("The Girl Is Mine", 222);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		items.add(book1);
		items.add(cd1);
		items.add(dvd1);
		for (Media item : items) {
			System.out.println(item.toString());
			// When we call the toString() method, it will call the method of the object's class, each class has its own toString() method
		}
	}
}
