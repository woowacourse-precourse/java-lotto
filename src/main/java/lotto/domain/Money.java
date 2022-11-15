package lotto.domain;

import static lotto.enumtype.LottoValidationMsg.*;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(NOT_INPUT_NEGATIVE_MONEY_EXCEPTION.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
