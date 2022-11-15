package lotto;

import java.util.Objects;

public class Money {
    private static final String MONEY_OVER_THOUSANDS_ERROR_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";
    private static final String MONEY_DIVIDE_ERROR_MESSAGE = "로또 구입 금액은 1000 단위여야 합니다.";
    private static final int DIVIDE_UNIT = 1000;

    private final int money;

    public Money(final int money) {
        validate(money);
        this.money = money;
    }

    private static void validate(final int money) {
        if (money < DIVIDE_UNIT) {
            throw new IllegalArgumentException(MONEY_OVER_THOUSANDS_ERROR_MESSAGE);
        }
        if (money % DIVIDE_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDE_ERROR_MESSAGE);
        }
    }

    public int toLottoCount() {
        return money / 1000;
    }

    public int get() {
        return money;
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
