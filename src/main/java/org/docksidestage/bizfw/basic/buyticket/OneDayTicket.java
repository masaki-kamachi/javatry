package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public class OneDayTicket implements Ticket {
    private final int displayPrice;
    private boolean alreadyIn;

    public OneDayTicket(int displayPrice) {
        this.displayPrice = displayPrice;
    }

    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }
    public boolean isAlreadyIn() {
        return alreadyIn;
    }
    public int getDayCount() {
        return 1;
    }
}
