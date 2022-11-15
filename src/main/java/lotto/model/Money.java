package lotto.model;

import java.util.Objects;

public class Money {

    public static final int LOTTO_PRICE = 1_000;

    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (!isValidUnit(money)) {
            throw new IllegalArgumentException("1,000원 단위로 입력해주세요.");
        }
    }

    private boolean isValidUnit(int money) {
        return money % LOTTO_PRICE == 0;
    }

    public int countLotto() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
