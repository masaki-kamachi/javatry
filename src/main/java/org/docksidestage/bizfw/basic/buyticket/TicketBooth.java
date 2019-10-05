/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

import java.util.Arrays;
import java.util.List;

// DONE chikama authorよろしくお願いしたい (俺が作ったことになってしまう) by jflute (2019/10/02)
// もしauthor運用をしないのであれば、逆に消したほうが良い。
/**
 * @author masaki.kamachi
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final List<TicketFactory> ticketFactories = Arrays.asList(new OneDayTicketFactory(), new SeveralDaysTicketFactory());

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // DONE chikama [確認]チケット残数は、OneDayとTwoDayで共有でいいのかな？ by jflute (2019/10/02)
    // つまり、OneDayが10枚売れたら、TwoDayは売り切れになるでOK？
    // チケットの残数はチケットの種類に寄らず共有する
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        return buyPassport(handedMoney, TicketType.ONE_DAY);
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        return buyPassport(handedMoney, TicketType.TWO_DAY);
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        return buyPassport(handedMoney, TicketType.FOUR_DAY);
    }

    private TicketBuyResult buyPassport(int handedMoney, TicketType type) {
        final int price = type.getPrice();
        final int count = type.getCount();

        if (quantity < count) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        quantity = quantity - count;

        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
        }
        final int charge = handedMoney - price;
        // DONE chikama [いいね]おお、かっこいい。ChainOfResponsibilityっぽい感じになってるのかも!? by jflute (2019/10/02)
        Ticket ticket = ticketFactories.stream()
                .filter(f -> f.suitable(type))
                .map(f -> f.create(type))
                .findFirst()
                // DONE chikama TicketTypeが見当たらないというよりも、対応するFactoryが見つからないってニュアンスなのかなと by jflute (2019/10/02)
                // もしくは、「不正なTicketType」ってニュアンス。
                .orElseThrow(() -> new TicketFactoryNotFoundException("Not fount type: " + type));
        return new TicketBuyResult(charge, ticket);
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    public static class TicketFactoryNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public TicketFactoryNotFoundException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
