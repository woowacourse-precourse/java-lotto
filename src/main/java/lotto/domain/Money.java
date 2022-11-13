package lotto.domain;

import lotto.domain.errorenum.Error;

public class Money {
    private static final int MIN_AMOUNT = 1000;
    private final int money;

    public Money(int money) {
        validateAbleToBuyAtLeastOne(money);
        validateChangeLeft(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int calculateBoughtLottoCount() {
        return money / MIN_AMOUNT;
    }

    private void validateAbleToBuyAtLeastOne(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalArgumentException(Error.MIN_MONEY_LIMIT.getCode());
        }
    }

    private void validateChangeLeft(int money) {
        if (money % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(Error.MONEY_CHANGE_LEFT.getCode());
        }
    }
}
