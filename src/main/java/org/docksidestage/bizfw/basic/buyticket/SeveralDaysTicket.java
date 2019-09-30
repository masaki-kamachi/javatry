package org.docksidestage.bizfw.basic.buyticket;

public class SeveralDaysTicket implements Ticket {

    private final int displayPrice;
    private final int count;
    private int remainCount;

    public SeveralDaysTicket(int displayPrice, int count) {
        this.displayPrice = displayPrice;
        this.count = count;
        this.remainCount = count;
    }

    public void doInPark() {
        if (remainCount < 1) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        remainCount--;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getCount() {
        return count;
    }

    public boolean isAlreadyIn() {
        return remainCount < 1;
    }
    public int getRemainCount() {
        return remainCount;
    }
}
