package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.IllegalMoneyInputException;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void validate(int money) throws IllegalArgumentException {
        if (money % LottoRule.COST.getValue() != 0 || money < LottoRule.COST.getValue()) {
            throw new IllegalMoneyInputException();
        }
    }

    public static Money of(int money) {
        return new Money(money);
    }
}
