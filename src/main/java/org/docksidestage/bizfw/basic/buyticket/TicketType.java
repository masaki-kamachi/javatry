package org.docksidestage.bizfw.basic.buyticket;

public enum TicketType {
    ONE_DAY(1, 7400), // when 2019/06/15
    TWO_DAY(2, 13200),
    FOUR_DAY(4, 22400);

    private int count;
    private int price;

    TicketType(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
