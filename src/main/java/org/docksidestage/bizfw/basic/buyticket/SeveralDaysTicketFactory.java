package org.docksidestage.bizfw.basic.buyticket;

public class SeveralDaysTicketFactory implements TicketFactory {
    @Override
    public boolean suitable(TicketType type) {
        return type.getCount() > 1;
    }

    @Override
    public Ticket create(TicketType type) {
        return new SeveralDaysTicket(type.getPrice(), type.getCount());
    }
}
