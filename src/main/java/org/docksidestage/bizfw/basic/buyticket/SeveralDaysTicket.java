package org.docksidestage.bizfw.basic.buyticket;

public class SeveralDaysTicket implements Ticket {

    private final int displayPrice;
    private int remainCount;

    public SeveralDaysTicket(int displayPrice, int day) {
        this.displayPrice = displayPrice;
        this.remainCount = day;
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

    public int getRemainCount() {
        return remainCount;
    }
}
