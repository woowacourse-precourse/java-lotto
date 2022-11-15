package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

public class Money {
    private static final int MIN_MONEY = 1000;
    private final String money;

    public Money(String money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(String money) {
        if (isNotNumeric(money)) {
            throw new ErrorException(Error.IS_NOT_NUMERIC.toString());
        }

        if (isInvalidMoney(Integer.parseInt(money))) {
            throw new ErrorException(Error.INVALID_BUY_MONEY.toString());
        }
    }

    private boolean isNotNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }

    private boolean isInvalidMoney(int money) {
        return (MIN_MONEY > money) || (money % MIN_MONEY) != 0;
    }

    public int getMoney() {
        return Integer.parseInt(money);
    }
}
