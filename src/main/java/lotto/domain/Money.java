package lotto.domain;

import static lotto.domain.ErrorMessages.MONEY_UNIT_ERROR;
import static lotto.domain.ErrorMessages.NEGATIVE_NUMBER_ERROR;
import static lotto.domain.ErrorMessages.ZERO_NUMBER_ERROR;

public class Money {
    private static final int UNIT_MONEY = 1_000;

    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isZeroMoney(money);
        isPositiveMoney(money);
        isValidUnitMoney(money);
    }

    private void isZeroMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(ZERO_NUMBER_ERROR.toString());
        }
    }

    private void isPositiveMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.toString());
        }
    }

    private void isValidUnitMoney(int money) {
        if (money  % UNIT_MONEY != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.toString());
        }
    }

    public int countLotto() {
        return money / UNIT_MONEY;
    }
}
