package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author maskai.kamachi
 */
public enum TicketType {
    ONE_DAY(1, 7400), // when 2019/06/15
    TWO_DAY(2, 13200),
    FOUR_DAY(4, 22400);

    // DONE chikama [ていあん]一応、final付けられるかなと。どこまで付けるかってさじ加減はあるけど by jflute (2019/10/02)
    final private int count;
    final private int price;

    // DONE chikama [ざつだん]そっか、private省略できるんだっけ... by jflute (2019/10/02)
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
