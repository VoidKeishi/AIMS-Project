package hust.soict.hedspi.aims.store;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore.add(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd){
        itemsInStore.remove(dvd);
    }

}
