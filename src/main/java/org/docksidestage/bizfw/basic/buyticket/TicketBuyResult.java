package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author masaki.kamachi
 */
public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // DONE chikama 空行削除 (TicketBoothとかタグコメントの下は空行開けてないので) by jflute (2019/10/02)
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
