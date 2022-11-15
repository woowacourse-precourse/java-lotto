package lotto.domain;

import lotto.exception.ExceptionPhrase;

import static lotto.exception.ExceptionPhrase.EXCEPTION_INVALID_MONEY_UNIT;

public class Money {
    private static final int TEN_THOUSAND_WON = 1000;

    private final int money;


    public Money(int money) {
        this.money = money;
        validateUnit(money);
    }

    private void validateUnit(int money) {
        if(money % TEN_THOUSAND_WON != 0 || money < 1000) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int lottoCount(int money) {
        return money / TEN_THOUSAND_WON;
    }
}
