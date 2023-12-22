package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("Track " + this.getTitle() + " can't be played");
		} else {			
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
    }
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track track = (Track) obj;
			if (this.title == track.title && this.length == track.length) {
				return true;
			}
		}
		return false;
	}
	public String playMedia(){
		String out = "Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength();
		return out;
	}
}
