package lotto.money;

import lotto.exception.ExceptionPhrase;

import static lotto.exception.ExceptionPhrase.EXCEPTION_INVALID_MONEY_UNIT;

public class Money {
    private static final int TEN_THOUSAND_WON = 1000;

    private int money;

    public Money(int money) {
        validateUnit(money);
        this.money = money;
    }

    private void validateUnit(int money) {
        if(money % TEN_THOUSAND_WON != 0) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int lottoCount() {
        return money / TEN_THOUSAND_WON;
    }
}
