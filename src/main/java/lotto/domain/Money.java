package lotto.domain;

import lotto.exception.ExceptionPhrase;

import static lotto.exception.ExceptionPhrase.EXCEPTION_INVALID_MONEY_UNIT;

public class Money {
    private static final int TEN_THOUSAND_WON = 1000;

    public Money() {
    }

    public int money(int money) {
        validateUnit(money);
        return money;
    }

    private void validateUnit(int money) {
        if(money % TEN_THOUSAND_WON != 0) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int lottoCount(int money) {
        return money / TEN_THOUSAND_WON;
    }
}
