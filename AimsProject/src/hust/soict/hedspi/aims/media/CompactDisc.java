package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track is already in the list");
			return;
		}
		tracks.add(track);
		System.out.println("Add track successfully");
	}
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Track is not in the list");
			return;
		}
		tracks.remove(track);
		System.out.println("Remove track successfully");
	}
	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
	}
}
