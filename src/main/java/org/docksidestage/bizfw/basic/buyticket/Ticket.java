package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public interface Ticket {
    void doInPark();
    int getDisplayPrice();
    int getDayCount();
    boolean isAlreadyIn();
}
