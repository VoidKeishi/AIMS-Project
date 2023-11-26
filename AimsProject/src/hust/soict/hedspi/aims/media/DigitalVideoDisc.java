
package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	public static int nbDigitalVideoDiscs = 0;
	
    public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setCost(cost);
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.setId(nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setLength(length);
		this.setCost(cost);
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.setId(nbDigitalVideoDiscs);
	}

    // Passing parameter - Section 15

    // Lab 03
	public String toString() {
		String result = id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
		return result;
	}

	public boolean isMatch(String title){
		if (this.title.toLowerCase().equals(title.toLowerCase())) {
			return true;
		}
		return false;
	}
	public boolean isMatch(int id){
		if (this.id == id) {
			return true;
		}
		return false;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}