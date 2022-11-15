package lotto.domain;

import static lotto.exception.ExceptionName.MONEY_NOT_INTEGER_EXCEPTION;
import static lotto.exception.ExceptionName.MONEY_UNIT_EXCEPTION;

public class Money {

    private final int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    public Money(String money) {
        Integer intMoney = validateInteger(money);
        validateUnit(intMoney);
        this.money = intMoney;
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_EXCEPTION);
        }
    }

    private Integer validateInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(MONEY_NOT_INTEGER_EXCEPTION);
        }
    }

    public int getMoney() {
        return money;
    }
}
