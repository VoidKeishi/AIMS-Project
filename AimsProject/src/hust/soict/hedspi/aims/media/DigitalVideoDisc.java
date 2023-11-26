
package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	public static int nbDigitalVideoDiscs = 0;
	
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost, director);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
    }

    // Passing parameter - Section 15

    // Lab 03
	public String toString() {
		String result = this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
		return result;
	}

	// public boolean isMatch(String title){
	// 	if (this.getTitle().toLowerCase().equals(title.toLowerCase())) {
	// 		return true;
	// 	}
	// 	return false;
	// }
	// public boolean isMatch(int id){
	// 	if (this.getId() == id) {
	// 		return true;
	// 	}
	// 	return false;
	// }
	
	public void play() {
    	if (this.getLength() <= 0) {
    		System.out.println("DVD " + this.getTitle() + " can't be played!");
    	} else {
    		System.out.println("Playing DVD: " + this.getTitle());
        	System.out.println("DVD length: " + this.getLength());
    	}
    }
}