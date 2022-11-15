package lotto.domain;

import static lotto.utils.ErrorMessage.MONEY_UNIT_ERROR;
import static lotto.utils.ErrorMessage.UNDER_MONEY_ERROR;

public class Money {
    private static final int UNIT_MONEY = 1_000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isUnderMoney(money);
        isValidUnitMoney(money);
    }

    private void isUnderMoney(int money) {
        if (money < UNIT_MONEY) {
            throw new IllegalArgumentException(UNDER_MONEY_ERROR.toString());
        }
    }

    private void isValidUnitMoney(int money) {
        if (money % UNIT_MONEY != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.toString());
        }
    }

    public int countLotto() {
        return money / UNIT_MONEY;
    }

    public int getMoney() {
        return money;
    }
}