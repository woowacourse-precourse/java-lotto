package lotto.domain.entity;

import static lotto.common.message.ExceptionMessage.AMOUNT_OF_MONEY_REMAINDER_NOT_ZERO_MESSAGE;
import static lotto.common.message.ExceptionMessage.ERROR_CODE;

import lotto.common.message.ExceptionMessage;

public class Money {


    private int money;

    private Money(int money) {
        moneyValidation(money);
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private void moneyValidation(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_CODE + AMOUNT_OF_MONEY_REMAINDER_NOT_ZERO_MESSAGE);
        }
    }

    public int currentTime() {
        return money / 1000;
    }

    public int currentMoney() {
        return money;
    }
}
