package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
		super();
	}
	protected void setLength(int length) {
		this.length = length;
	}
	protected void setDirector(String director) {
		this.director = director;
	}
}