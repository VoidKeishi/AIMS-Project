package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
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
	// id - "Book" - title - category - authors - cost
	public String toString() {
		String authors = "";
		for (String author : this.authors) {
			authors += author + ", ";
		}
		// Remove the last ", "
		authors = authors.substring(0, authors.length() - 2);
		return this.getId() + ". Book - " + this.getTitle() + " - " + this.getCategory() + " - " + authors + ": " + this.getCost() + "$";
	}

}
