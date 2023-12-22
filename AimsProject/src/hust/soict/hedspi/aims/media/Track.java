package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track track = (Track) obj;
			if (this.title == track.title && this.length == track.length) {
				return true;
			}
		}
		return false;
	}
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	public String playMedia() throws PlayerException{
		if (this.getLength() > 0) {
			String out = "Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength();
			return out;
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
