package lotto.domain;

import java.util.List;

public class Customer {
    private final int paidMoney;
    private final int numOfTicket;

    public Customer(int paidMoney) {
        this.paidMoney = paidMoney;
        this.numOfTicket = this.paidMoney / 1000;
    }
}
