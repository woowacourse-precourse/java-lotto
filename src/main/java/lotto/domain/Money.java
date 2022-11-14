package lotto.domain;

import lotto.exception.InvalidNumberException;
import lotto.exception.money.MoneyNumberRangeException;
import lotto.exception.money.MoneyDividePriceException;
import lotto.exception.money.MoneyStartZeroNumberException;

public class Money {
    private static final int MAX_PURCHASE = 100000;
    private static final int MIN_PURCHASE = 1000;
    private static final int PRICE = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public void validate(int money) {
        validateNumberRange(money);
        validateDividedPrice(money);
    }

    private void validateNumberRange(int money) {
        if ((money < MIN_PURCHASE) || (money > MAX_PURCHASE)) {
            throw new MoneyNumberRangeException(MIN_PURCHASE, MAX_PURCHASE);
        }
    }

    private void validateDividedPrice(int money) {
        if ((money % PRICE) != 0) {
            throw new MoneyDividePriceException(PRICE);
        }
    }

    public int calculateLottoAmount() {
        return (money / PRICE);
    }

    public int getMoney() {
        return money;
    }
}
