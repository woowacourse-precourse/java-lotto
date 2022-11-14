package lotto.domain;

import exception.MoneyIllegalArgumentException;


public class Money {

    private final static int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    private void validate(int money) throws MoneyIllegalArgumentException {
        if (divideLottoPriceIsNotZero(money)) {
            throw new MoneyIllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private boolean divideLottoPriceIsNotZero(int value) {
        int remainder = value % LOTTO_PRICE;
        if (remainder == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int exchangeLotto() {
        return money / LOTTO_PRICE;
    }
}
