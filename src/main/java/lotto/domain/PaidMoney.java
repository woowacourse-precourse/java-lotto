package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static lotto.view.Constants.BOUGHT_NOTHING;
import static lotto.view.Constants.NOT_DIVISIBLE_BY_THOUSAND;

public class PaidMoney {
    private final int paidMoney;
    private int earnedMoney = 0;

    public PaidMoney(int paidMoney) {
        validateNoMoney(paidMoney);
        validateWrongMoney(paidMoney);
        this.paidMoney = paidMoney;
    }

    public int buyNTicket() {
        return paidMoney / 1000;
    }

    private void validateNoMoney(int paidMoney) {
        if (paidMoney == 0) {
            System.out.println(BOUGHT_NOTHING);
            throw new IllegalArgumentException();
        }
    }

    private void validateWrongMoney(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            System.out.println(NOT_DIVISIBLE_BY_THOUSAND);
            throw new IllegalArgumentException();
        }
    }
}
