package lotto.domain;

import static lotto.utils.ErrorMessages.*;

public class Money {
    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MONEY_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateRange(money);
        validateDivideUnit(money);
    }

    private void validateRange(int money) {
        if (money < MIN_MONEY_RANGE) {
            throw new IllegalArgumentException(MONEY_OUT_OF_RANGE);
        }
    }

    private void validateDivideUnit(int money) {
        if (money % MONEY_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDE_UNIT);
        }
    }

    public int getMoney() {
        return this.money;
    }
}
