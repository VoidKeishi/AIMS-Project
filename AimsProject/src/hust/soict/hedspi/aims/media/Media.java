package hust.soict.hedspi.aims.media;

import java.util.Comparator;

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
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public boolean isMatch(String title){
		return (this.getTitle().toLowerCase().equals(title.toLowerCase()));
	}
    
    public boolean isMatch(int id) {
    	return this.getId() == id;
    }
}
