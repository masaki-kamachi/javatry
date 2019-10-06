package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public interface TicketFactory {
    boolean suitable(TicketType type);
    Ticket create(TicketType type);
}
