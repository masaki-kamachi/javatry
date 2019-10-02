package org.docksidestage.bizfw.basic.buyticket;

public class SeveralDaysTicket implements Ticket {

    private final int displayPrice;
    // TODO chikama countとremainCountが並んでるのが少し気になる...一瞬countがわからなかった by jflute (2019/10/02)
    // 最大回数とか日数とか、何かしらニュアンスが入るといいのかも？
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
