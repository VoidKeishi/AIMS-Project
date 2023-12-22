
package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, director, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
    }

    // id - DVD - title - category - director - length - cost
	public String toString() {
		String result = this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
		return result;
	}
	
	public void play() {
    	if (this.getLength() <= 0) {
    		System.out.println("DVD " + this.getTitle() + " can't be played!");
    	} else {
    		System.out.println("Playing DVD: " + this.getTitle());
        	System.out.println("DVD length: " + this.getLength());
    	}
    }
	
	public String playMedia(){
		String out = "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
		return out;
	}
}