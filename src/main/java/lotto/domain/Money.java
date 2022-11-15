package lotto.domain;

import static lotto.enumtype.LottoValidationMsg.*;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getCountByPrice(int price) {
        if (money % price > 0) {
            throw new IllegalArgumentException(NOT_INSERT_COINS_EXCEPTION.getMessage());
        }

        return money / price;
    }

    public double getYield(long total) {
        return (int) Math.round((double)total / money * 1000) / 10.0;
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
