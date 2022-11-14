package lotto.domain;

import java.util.Objects;

public class Money {

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public static Money empty() {
        return new Money(0);
    }

    public int exchangeLotto() {
        validateLottoUnit(money);
        return money / 1000;
    }

    private void validateLottoUnit(int money) {
        if (money % 1000 != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주세요");
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

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }

    public double divide(Money other) {
        return (double) money / other.money;
    }
}
