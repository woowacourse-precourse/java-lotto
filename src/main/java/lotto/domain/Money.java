package lotto.domain;

import static lotto.domain.Error.MONEY_UNIT_ERROR;

public class Money {
    private static final int UNIT_MONEY = 1_000;

    private int money;

    public Money(int money) {
        isValidMoney(money);
        this.money = money;
    }

    private void isValidMoney(int money) {
        if (money  % UNIT_MONEY != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.toString());
        }
    }
}
