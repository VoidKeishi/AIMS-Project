package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();

	public Book(){
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author is already in the list");
			return;
		}
		authors.add(authorName);
		System.out.println("Add author successfully");
	}

	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Author is not in the list");
			return;
		}
		authors.remove(authorName);
		System.out.println("Remove author successfully");
	}
}
