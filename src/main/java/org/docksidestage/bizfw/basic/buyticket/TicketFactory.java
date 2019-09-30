package org.docksidestage.bizfw.basic.buyticket;

public interface TicketFactory {
    boolean suitable(TicketType type);
    Ticket create(TicketType type);
}
