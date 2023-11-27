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
	public Disc(int id, String title) {
        super(id, title);
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String category, String director,  float cost) {
        super(id, title, category, cost);
        this.director = director;
    }

    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
	
	protected void setLength(int length) {
		this.length = length;
	}
	protected void setDirector(String director) {
		this.director = director;
	}
}
