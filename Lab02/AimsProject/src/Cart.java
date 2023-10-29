public class Cart {
    
    // Initialize Cart class - Section 11
    // Attributes
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    // Methods
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added to the cart");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered > 0) {
            int flag = 0;
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                    for (int j = i; j < qtyOrdered - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    qtyOrdered--;
                    flag = 1;
                    System.out.println("The disc has been removed");
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The disc is not in the cart");
            }
        } 
        else {
            System.out.println("The cart is empty");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Print number, title and cost of DVDs in the cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d%-20s%-5.2f$\n", i + 1, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
        }
        System.out.printf("   Total cost:         %-5.2f$\n", totalCost());
        System.out.println("***************************************************");
    }
    
    // Method overloading - Section 14
    // Overloading by differing the type of parameters - Section 14.1
    // Add a list of DVDs to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBER_ORDERED) {
            for (DigitalVideoDisc digitalVideoDisc : dvdList) {
                itemsOrdered[qtyOrdered] = digitalVideoDisc;
                qtyOrdered++;
            }
            System.out.println("The discs have been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    
    // Pass an arbitrary number of DVDs to the cart
    // public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    //     if (qtyOrdered + dvdList.length <= MAX_NUMBER_ORDERED) {
    //         for (DigitalVideoDisc digitalVideoDisc : dvdList) {
    //             itemsOrdered[qtyOrdered] = digitalVideoDisc;
    //             qtyOrdered++;
    //         }
    //         System.out.println("The discs have been added");
    //     }
    //     else {
    //         System.out.println("The cart is almost full");
    //     }
    // }
    /* Pass an array of DVDs to the cart vs pass an arbitrary number of DVDs to the cart:
    - The difference is that the first one requires an array as a parameter while the second one requires a list of parameters.
    - The first one is more suitable when we have an array of DVDs and we want to add all of them to the cart.
    - The second one is more suitable when we have a bigger list of DVDs and we want to add all of them (with some conditions) to the cart.
    */
    
    // Overloading by differing the number of parameters - Section 14.2
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
        }
    }
}