package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int result = m1.getTitle().compareTo(m2.getTitle());
        if (result != 0) return result;
        else return Float.compare(m1.getCost(), m2.getCost());
    }
}