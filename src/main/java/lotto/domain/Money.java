package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

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
        if (money % LottoRule.COST.getValueForRule() != 0 || money < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
    }

    public static Money of(int money) {
        return new Money(money);
    }
}
