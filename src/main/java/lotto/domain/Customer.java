package lotto.domain;

import java.util.List;

import static lotto.view.Constants.NOT_DIVISIBLE_BY_THOUSAND;

public class Customer {
    private final int paidMoney;
    private final int numOfTicket;

    public Customer(int paidMoney) {
        validateProperMoney(paidMoney);
        this.paidMoney = paidMoney;
        this.numOfTicket = this.paidMoney / 1000;
    }

    private void validateProperMoney(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND);
        }
    }
}
