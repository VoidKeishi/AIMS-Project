package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String artist) {
        super(id, title);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String artist, String category, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String artist, String category, String director, float cost) {
        super(id, title, category, director, cost);
        this.artist = artist;
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
	public String toString() {
		String tracks = "";
		for (Track track : this.tracks) {
			tracks += track.getTitle() + ", ";
		}
		//Remove the last ", "
		tracks = tracks.substring(0, tracks.length() - 2);
		return this.getId() + ". CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + tracks + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
	
	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}		
	// id - CD - title - category - artist - tracks - length - cost

	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
	 		for (Track track: tracks) {
				try {
					track.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	public String playMedia() throws PlayerException{
		if(this.getLength() > 0) {
			String out = "Playing CD: " + this.getTitle() + "\n";
			for (Track track: tracks) {
				out += track.playMedia();
				out += "\n";
			}
			return out;
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
}
