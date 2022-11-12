package lotto.domain;

import java.util.Objects;
import lotto.exception.domain.MoneyMinimumException;

public class Money {
    private static final long MONEY_MIN = 1;
    private final long money;

    public Money(long money) {
        validateMinimum(money);
        this.money = money;
    }

    private void validateMinimum(long money) {
        if (money < MONEY_MIN) {
            throw new MoneyMinimumException(MONEY_MIN);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
