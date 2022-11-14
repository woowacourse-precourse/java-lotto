package lotto;

import static lotto.constant.Rules.LOTTO_PRICE;

import lotto.exception.WrongMoneyException;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (!verifyUnit(money)) {
            throw new WrongMoneyException();
        }
    }

    private boolean verifyUnit(int money) {
        return money % LOTTO_PRICE == 0;
    }
}
