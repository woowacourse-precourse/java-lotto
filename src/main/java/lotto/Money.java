package lotto;

import static lotto.constant.Rules.LOTTO_PRICE;

import lotto.exception.MoneyNotDividedByPriceException;
import lotto.exception.MoneyRangeException;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (!verifyRange(money)) {
            throw new MoneyRangeException();
        }
        if (!verifyDividedByPrice(money)) {
            throw new MoneyNotDividedByPriceException();
        }
    }

    private boolean verifyRange(int money) {
        return money >= LOTTO_PRICE;
    }

    private boolean verifyDividedByPrice(int money) {
        return money % LOTTO_PRICE == 0;
    }
}
