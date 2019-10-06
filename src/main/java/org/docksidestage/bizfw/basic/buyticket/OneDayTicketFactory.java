package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public class OneDayTicketFactory implements TicketFactory {
    @Override
    public boolean suitable(TicketType type) {
        return type.getCount() == 1;
    }

    @Override
    public Ticket create(TicketType type) {
        return new OneDayTicket(type.getPrice());
    }
}
