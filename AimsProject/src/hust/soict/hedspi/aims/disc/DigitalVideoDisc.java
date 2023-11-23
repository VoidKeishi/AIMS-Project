package hust.soict.hedspi.aims.disc;
public class DigitalVideoDisc {
    // Attributes - Section 8
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
	// Class member - Section 16
	public static int nbDigitalVideoDiscs = 0;
	// Instance member - Section 16
	private int id;

    // Getters - Section 9
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Constructors - Section 10
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

    // Temporary add a setter for title
	public void setTitle(String title) {
		this.title = title;
	}

}