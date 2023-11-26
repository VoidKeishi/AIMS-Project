package hust.soict.hedspi.aims.media;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setCategory(String category) {
		this.category = category;
	}

	protected void setCost(float cost) {
		this.cost = cost;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media media = (Media) obj;
			if (this.title == media.title) {
				return true;
			}
		}
		return false;
	}
}
