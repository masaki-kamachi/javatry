package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public class SeveralDaysTicket implements Ticket {

    private final int displayPrice;
    // DONE chikama countとremainCountが並んでるのが少し気になる...一瞬countがわからなかった by jflute (2019/10/02)
    // 最大回数とか日数とか、何かしらニュアンスが入るといいのかも？
    private final int dayCount;
    private int remainCount;

    public SeveralDaysTicket(int displayPrice, int dayCount) {
        this.displayPrice = displayPrice;
        this.dayCount = dayCount;
        this.remainCount = dayCount;
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

    public int getDayCount() {
        return dayCount;
    }

    public boolean isAlreadyIn() {
        return remainCount < 1;
    }
    public int getRemainCount() {
        return remainCount;
    }
}
