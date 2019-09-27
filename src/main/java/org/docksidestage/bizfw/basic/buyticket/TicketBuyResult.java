package org.docksidestage.bizfw.basic.buyticket;

public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    private final int change;
    private final Ticket ticket;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(int charge, Ticket ticket) {
        this.change = charge;
        this.ticket = ticket;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========

    public int getChange() {
        return change;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
