package lotto.domain.money;

import lotto.global.message.ErrorMessage;
import lotto.global.message.Number;

public class Money {

    private final Integer money;

    public Money(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money) {
        if (money < Number.ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
        if (money % Number.ONE_THOUSAND != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_THOUSANDS_OF_NUMBER);
        }
    }

    public static Money create(Integer money) {
        return new Money(money);
    }

    public Integer getCount() {
        return money / Number.ONE_THOUSAND;
    }
}
