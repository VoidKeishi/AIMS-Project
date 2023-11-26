package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        if (m1.getCost() < m2.getCost()) return -1;
        if (m1.getCost() > m2.getCost()) return 1;
        return m1.getTitle().compareTo(m2.getTitle());
    }
}