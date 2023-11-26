
package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	public static int nbDigitalVideoDiscs = 0;
	public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
	
    public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		// Increase the number of DVDs
		nbDigitalVideoDiscs++;
		// Set the id of the DVD
		this.id = nbDigitalVideoDiscs;
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